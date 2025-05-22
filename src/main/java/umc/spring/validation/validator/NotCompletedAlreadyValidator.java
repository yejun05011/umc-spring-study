package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.validation.annotation.NotCompletedAlready;

@RequiredArgsConstructor
public class NotCompletedAlreadyValidator implements ConstraintValidator<NotCompletedAlready, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        // memberId는 하드코딩
        return memberMissionRepository.findByMemberIdAndMissionId(1L, missionId) // 하드코딩된 멤버
                .map(mm -> mm.getStatus() != MissionStatus.COMPLETE)
                .orElse(true);
    }
}

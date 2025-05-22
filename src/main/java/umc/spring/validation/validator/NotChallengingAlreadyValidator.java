package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.validation.annotation.NotChallengingAlready;

@Component
@RequiredArgsConstructor
public class NotChallengingAlreadyValidator implements ConstraintValidator<NotChallengingAlready, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        // 하드코딩, memberId = 1L 기준
        return memberMissionRepository.findByMemberIdAndMissionId(1L, missionId)
                .map(mm -> mm.getStatus() != MissionStatus.CHALLENGING)
                .orElse(true);
    }
}


package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.validation.annotation.NotChallengingAlready;

@Component
@RequiredArgsConstructor
public class NotChallengingAlreadyValidator implements ConstraintValidator<NotChallengingAlready, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long memberId = 1L; // 하드코딩된 멤버 ID
        return !memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);
    }
}

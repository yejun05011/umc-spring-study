package umc.spring.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionQueryService {
    Page<MemberMission> getChallengingMissions(Long memberId, int page);
}

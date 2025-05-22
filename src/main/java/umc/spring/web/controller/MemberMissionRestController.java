package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionQueryService;
import umc.spring.service.MemberMissionService.MemberMissionService;
import umc.spring.validation.annotation.NotChallengingAlready;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionRestController {

    private final MemberMissionService memberMissionService;

    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<String> challengeMission(@PathVariable @NotChallengingAlready Long missionId) {
        memberMissionService.challengeMission(missionId);
        return ApiResponse.onSuccess("도전 완료!");
    }

    @GetMapping("/members/me/missions")
    public ApiResponse<MissionResponseDTO.MissionPreviewListDTO> getMyChallengingMissions(@ValidPage @RequestParam("page") Integer page) {
        Long memberId = 1L; // 하드코딩
        Page<MemberMission> resultPage = memberMissionQueryService.getChallengingMissions(memberId, page);
        return ApiResponse.onSuccess(MissionConverter.toMemberMissionPreviewListDTO(resultPage));
    }
}
package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.MemberMissionService.MemberMissionService;
import umc.spring.validation.annotation.NotChallengingAlready;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionRestController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<String> challengeMission(@PathVariable @NotChallengingAlready Long missionId) {
        memberMissionService.challengeMission(missionId);
        return ApiResponse.onSuccess("도전 완료!");
    }
}

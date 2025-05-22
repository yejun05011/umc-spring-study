package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    private final MissionQueryService missionQueryService;

    private final StoreRepository storeRepository;

    @PostMapping("/{storeId}/missions")
    public ApiResponse<MissionResponseDTO> createMission(@PathVariable Long storeId, @RequestBody @Valid MissionRequestDTO.CreateDTO request) {
        Mission mission = missionCommandService.createMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.toDTO(mission));
    }

    @GetMapping("/{storeId}/missions")
    public ApiResponse<MissionResponseDTO.MissionPreviewListDTO> getMissionListByStore(
            @PathVariable(name = "storeId") Long storeId,
            @ValidPage @RequestParam(name = "page") Integer page) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        Page<Mission> missionPage = missionQueryService.getMissionListByStore(store, page);
        return ApiResponse.onSuccess(MissionConverter.toPreviewListDTO(missionPage));
    }
}

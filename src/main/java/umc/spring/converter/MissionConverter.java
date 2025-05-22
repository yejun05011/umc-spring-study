package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.util.List;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.CreateDTO dto, Store store) {
        return Mission.builder()
                .missionSpec(dto.getDescription())
                .reward(dto.getRewardPoint())
                .deadline(dto.getDeadline())
                .store(store)
                .build();
    }

    public static MissionResponseDTO toDTO(Mission mission) {
        return new MissionResponseDTO(
                mission.getId(),
                mission.getStore().getName(),
                mission.getReward()
        );
    }

    public static MissionResponseDTO.MissionPreviewDTO toPreviewDTO(Mission mission) {
        return new MissionResponseDTO.MissionPreviewDTO(
                mission.getId(),
                mission.getMissionSpec(),
                mission.getReward(),
                mission.getStore().getName(),
                mission.getDeadline()
        );
    }

    public static MissionResponseDTO.MissionPreviewListDTO toMissionPreviewListDTO(Page<Mission> missions) {
        List<MissionResponseDTO.MissionPreviewDTO> list = missions.stream()
                .map(MissionConverter::toPreviewDTO)
                .toList();

        return new MissionResponseDTO.MissionPreviewListDTO(
                list,
                list.size(),
                missions.getTotalPages(),
                missions.getTotalElements(),
                missions.isFirst(),
                missions.isLast()
        );
    }

    public static MissionResponseDTO.MissionPreviewListDTO toMemberMissionPreviewListDTO(Page<MemberMission> page) {
        List<MissionResponseDTO.MissionPreviewDTO> list = page.getContent().stream()
                .map(mm -> new MissionResponseDTO.MissionPreviewDTO(
                        mm.getMission().getId(),
                        mm.getMission().getMissionSpec(),
                        mm.getMission().getReward(),
                        mm.getMission().getStore().getName(),
                        mm.getMission().getDeadline()
                )).toList();

        return new MissionResponseDTO.MissionPreviewListDTO(
                list,
                list.size(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.isFirst(),
                page.isLast()
        );
    }
}

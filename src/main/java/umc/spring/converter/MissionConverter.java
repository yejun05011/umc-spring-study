package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

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
                mission.getMissionSpec(),
                mission.getStore().getName(),
                mission.getReward()
        );
    }
}

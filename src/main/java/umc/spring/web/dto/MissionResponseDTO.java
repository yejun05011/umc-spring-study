package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionResponseDTO {
    private Long id;
    private String title;
    private String storeName;
    private Integer rewardPoint;
}
package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class MissionResponseDTO {

    private Long id;
    private String storeName;
    private Integer rewardPoint;

    @Getter
    @AllArgsConstructor
    public static class MissionPreviewDTO {
        private Long id;
        private String missionSpec;
        private Integer reward;
        private String storeName;
        private LocalDate deadline;
    }

    @Getter
    @AllArgsConstructor
    public static class MissionPreviewListDTO {
        private List<MissionPreviewDTO> missions;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
}
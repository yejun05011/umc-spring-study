package umc.spring.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class CreateDTO {

        @NotBlank
        private String title;

        @NotBlank
        private String description;

        @NotNull
        @Min(1)
        private Integer rewardPoint;

        @NotNull
        @Future
        private LocalDate deadline;
    }
}

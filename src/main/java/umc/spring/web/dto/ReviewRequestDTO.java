package umc.spring.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStore;

public class ReviewRequestDTO {

    @Getter
    public static class CreateDTO {

        @Min(value = 1)
        @Max(value = 5)
        @NotNull
        private Integer rating;

        @NotBlank
        private String content;
    }
}

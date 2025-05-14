package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class CreateDTO {

        @NotBlank
        private String name;

        @NotBlank
        private String address;
    }
}

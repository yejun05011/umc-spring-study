package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewResponseDTO {
    private Long id;
    private String content;
    private Float score;
    private String storeName;
}

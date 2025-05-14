package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateDTO dto, Store store, Member member) {
        return Review.builder()
                .body(dto.getContent())
                .score(dto.getRating().floatValue())
                .store(store)
                .member(member)
                .build();
    }

    public static ReviewResponseDTO toDTO(Review review) {
        return new ReviewResponseDTO(
                review.getId(),
                review.getBody(),
                review.getScore(),
                review.getStore().getName()
        );
    }
}

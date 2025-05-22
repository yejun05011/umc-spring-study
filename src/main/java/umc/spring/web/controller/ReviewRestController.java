package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.service.ReviewService.ReviewQueryService;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.validation.annotation.ValidPage;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.repository.MemberRepository.MemberRepository;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    private final ReviewQueryService reviewQueryService;

    private final MemberRepository memberRepository;


    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO> createReview(@PathVariable @ExistStore Long storeId,
                                                       @RequestBody @Valid ReviewRequestDTO.CreateDTO request) {
        Review review = reviewCommandService.createReview(storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toDTO(review));
    }

    @GetMapping("/me/reviews")
    public ApiResponse<List<ReviewResponseDTO>> getMyReviews(
            @ValidPage @RequestParam("page") Integer page
    ) {
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("No such member"));

        Page<Review> reviewPage = reviewQueryService.getMyReviewList(member, page);
        List<ReviewResponseDTO> responseList = reviewPage.stream()
                .map(ReviewConverter::toDTO)
                .toList();

        return ApiResponse.onSuccess(responseList);
    }

}

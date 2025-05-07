package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.apiPayload.code.status.SuccessStatus;
import umc.spring.converter.TempConverter;
import umc.spring.service.TempService.TempQueryService;
import umc.spring.web.dto.TempResponse;

@RestController
@RequestMapping("/temp")
public class TempRestController {

    private final TempQueryService tempQueryService;

    public TempRestController(@Qualifier("tempQueryServiceImpl") TempQueryService tempQueryService) {
        this.tempQueryService = tempQueryService;
    }

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO(), SuccessStatus._OK);
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam("flag") Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}

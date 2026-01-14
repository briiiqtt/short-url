package dev.briiiqtt.shorturl.url.controller;

import dev.briiiqtt.shorturl.common.ApiResponse;
import dev.briiiqtt.shorturl.url.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @PostMapping("/shorten")
    public ApiResponse<CreateUrlResponse> shorten(@RequestBody CreateUrlRequest req) {
        String result = urlService.createUrl(req.url());
        CreateUrlResponse response = new CreateUrlResponse(result);
        return ApiResponse.success(response);
    }
}

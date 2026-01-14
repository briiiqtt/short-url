package dev.briiiqtt.shorturl.url;

import dev.briiiqtt.shorturl.url.dto.request.CreateUrlRequest;
import dev.briiiqtt.shorturl.url.dto.response.CreateUrlResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @PostMapping("/shorten")
    public CreateUrlResponse shorten(@RequestBody CreateUrlRequest req) {
        String result = urlService.createUrl(req.url());
        return new CreateUrlResponse(result);
    }
}

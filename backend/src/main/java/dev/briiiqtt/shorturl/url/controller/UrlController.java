package dev.briiiqtt.shorturl.url.controller;

import dev.briiiqtt.shorturl.url.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<CreateUrlResponse> shorten(@RequestBody CreateUrlRequest req) {
        String result = urlService.createUrl(req);
        return ResponseEntity.status(HttpStatus.OK).body(new CreateUrlResponse(result));
    }
}

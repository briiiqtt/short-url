package dev.briiiqtt.shorturl.url.controller;

import dev.briiiqtt.shorturl.url.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @PostMapping("/shorten")
    public CreateUrlResponse shorten(@RequestBody CreateUrlRequest req) {
        System.out.println("SHORTEN REQ RECVD");
        System.out.println(req.url());
        String result = urlService.createUrl(req.url());
        return new CreateUrlResponse(result);
    }
}

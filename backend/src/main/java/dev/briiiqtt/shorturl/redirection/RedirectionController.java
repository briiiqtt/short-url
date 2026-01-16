package dev.briiiqtt.shorturl.redirection;

import dev.briiiqtt.shorturl.exception.UrlNotFoundException;
import dev.briiiqtt.shorturl.url.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class RedirectionController {
    private final UrlService urlService;

    @GetMapping("/{encodedId}")
    public ResponseEntity<Void> redirect(@PathVariable String encodedId) {
        String url = urlService.readUrl(encodedId);
        if (url == null) {
            throw new UrlNotFoundException(encodedId);
        }
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build();
    }
}

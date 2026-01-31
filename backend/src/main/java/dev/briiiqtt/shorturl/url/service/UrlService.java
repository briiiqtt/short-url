package dev.briiiqtt.shorturl.url.service;

import dev.briiiqtt.shorturl.cache.UrlCache;
import dev.briiiqtt.shorturl.cache.UrlCacheService;
import dev.briiiqtt.shorturl.url.controller.CreateUrlRequest;
import dev.briiiqtt.shorturl.url.domain.UrlEntity;
import dev.briiiqtt.shorturl.url.domain.UrlRepository;
import dev.briiiqtt.shorturl.util.EncodingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;
    private final UrlCacheService urlCacheService;
    private final EncodingService encodingService;

    public String createUrl(CreateUrlRequest req) {
        UrlEntity entity = UrlEntity.of(req.url());
        entity = urlRepository.save(entity);
        entity.assignShortenedUrl(encodingService.encode(entity.getId()));
        return entity.getShortenedUrl();
    }

    public String readUrl(String req) {
        long id = encodingService.decode(req);

        UrlCache urlCache = urlCacheService.getUrl(id);
        if (urlCache != null) {
            return urlCache.getOriginalUrl();
        }

        Optional<UrlEntity> o = urlRepository.findById(id);
        if (o.isEmpty()) return null;

        UrlEntity entity = o.get();

        urlCacheService.saveUrl(UrlCache.of(entity.getShortenedUrl(), entity.getOriginalUrl()));

        return entity.getOriginalUrl();
    }
}

package dev.briiiqtt.shorturl.url.service;

import dev.briiiqtt.shorturl.cache.UrlCache;
import dev.briiiqtt.shorturl.cache.UrlCacheService;
import dev.briiiqtt.shorturl.url.domain.UrlEntity;
import dev.briiiqtt.shorturl.url.domain.UrlRepository;
import dev.briiiqtt.shorturl.util.Base62;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;
    private final UrlCacheService urlCacheService;

    public String createUrl(String req) {
        UrlEntity entity = new UrlEntity();
        entity.setUrl(req);
        urlRepository.save(entity);
        urlCacheService.saveUrl(new UrlCache(entity.getId(), entity.getUrl()));
        return entity.getShortenUrl();
    }

    public String readUrl(String req) {
        long id = Base62.decode(req);

        UrlCache urlCache = urlCacheService.getUrl(id);
        if (urlCache != null) {
            return urlCache.getUrl();
        }

        Optional<UrlEntity> o = urlRepository.findById(id);
        if (o.isEmpty()) return null;

        UrlEntity entity = o.get();
        return entity.getUrl();
    }
}

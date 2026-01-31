package dev.briiiqtt.shorturl.cache;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "url", timeToLive = 3600)
@Getter
@Setter
public class UrlCache {
    @Id
    private String shortenedUrl;
    private String originalUrl;

    public static UrlCache of(String shortenedUrl, String originalUrl) {
        UrlCache urlCache = new UrlCache();
        urlCache.shortenedUrl = shortenedUrl;
        urlCache.originalUrl = originalUrl;
        return urlCache;
    }
}

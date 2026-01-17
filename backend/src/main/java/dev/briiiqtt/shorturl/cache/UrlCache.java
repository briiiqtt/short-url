package dev.briiiqtt.shorturl.cache;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "url", timeToLive = 3600)
@Getter
@Setter
public class UrlCache {
    @Id
    private Long id;
    private String url;

    public UrlCache(Long id, String url) {
        this.id = id;
        this.url = url;
    }
}

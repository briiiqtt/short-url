package dev.briiiqtt.shorturl.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlCacheService {
    private final UrlCacheRepository urlCacheRepository;

    public void saveUrl(UrlCache user) {
        urlCacheRepository.save(user);
    }

    public UrlCache getUrl(Long id) {
        return urlCacheRepository.findById(id).orElse(null);
    }
}
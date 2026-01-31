package dev.briiiqtt.shorturl.cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlCacheService {
    private final UrlCacheRepository urlCacheRepository;

    public void saveUrl(UrlCache user) {
        urlCacheRepository.save(user);
    }

    public UrlCache getUrl(Long id) {
        try {
            return urlCacheRepository.findById(id).orElse(null);
        } catch (DataAccessException e) {
            log.error("redis access failed", e);
            return null;
        }
    }
}
package dev.briiiqtt.shorturl.cache;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UrlCacheRepository extends CrudRepository<UrlCache, Long> {
    List<UrlCache> findByName(String name);
}

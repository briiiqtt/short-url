package dev.briiiqtt.shorturl.cache;

import org.springframework.data.repository.CrudRepository;

public interface UrlCacheRepository extends CrudRepository<UrlCache, Long> {
}

package dev.briiiqtt.shorturl.url;

import dev.briiiqtt.shorturl.BaseRepository;
import dev.briiiqtt.shorturl.url.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends BaseRepository<UrlEntity, Long>, JpaRepository<UrlEntity, Long> {
}

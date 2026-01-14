package dev.briiiqtt.shorturl.url.domain;

import dev.briiiqtt.shorturl.common.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends BaseRepository<UrlEntity, Long>, JpaRepository<UrlEntity, Long> {
}

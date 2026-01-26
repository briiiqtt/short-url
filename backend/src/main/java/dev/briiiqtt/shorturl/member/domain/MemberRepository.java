package dev.briiiqtt.shorturl.member.domain;

import dev.briiiqtt.shorturl.common.BaseRepository;
import dev.briiiqtt.shorturl.url.domain.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends BaseRepository<UrlEntity, Long>, JpaRepository<UrlEntity, Long> {
    Optional<MemberEntity> findByEmail(String email);
}

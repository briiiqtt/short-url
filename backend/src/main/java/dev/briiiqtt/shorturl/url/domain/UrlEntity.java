package dev.briiiqtt.shorturl.url.domain;

import dev.briiiqtt.shorturl.common.BaseEntity;
import dev.briiiqtt.shorturl.util.Base62;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UrlEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    public String getShortenUrl() {
        return Base62.encode(this.id);
    }

    public UrlEntity(String url) {
        this.url = url;
    }
}

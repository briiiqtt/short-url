package dev.briiiqtt.shorturl.url.entity;

import dev.briiiqtt.shorturl.BaseEntity;
import dev.briiiqtt.shorturl.util.Base62;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UrlEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    public String getShortenUrl() {
        return Base62.encode(this.id);
    }
}

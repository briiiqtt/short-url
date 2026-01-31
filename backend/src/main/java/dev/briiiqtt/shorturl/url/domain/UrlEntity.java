package dev.briiiqtt.shorturl.url.domain;

import dev.briiiqtt.shorturl.common.BaseEntity;
import dev.briiiqtt.shorturl.exception.InvalidInputException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UrlEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    public static UrlEntity of(String url) {
        //TODO: Apache Commons Validator 고려

        try {
            var __ = new URI(url).toURL();
        } catch (IllegalArgumentException | NullPointerException | MalformedURLException | URISyntaxException e) {
            throw new InvalidInputException();
        }

        UrlEntity entity = new UrlEntity();
        entity.url = url;
        return entity;
    }
}

package dev.briiiqtt.shorturl.url.domain;

import dev.briiiqtt.shorturl.common.BaseEntity;
import dev.briiiqtt.shorturl.exception.InvalidInputException;
import jakarta.persistence.*;
import lombok.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

@Entity
@Table(
        name = "url",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_url_shortened_url",
                        columnNames = {"shortened_url"}
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UrlEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "url_seq",
            sequenceName = "url_seq",
            allocationSize = 50
    )
    private Long id;

    private String originalUrl;

    private String shortenedUrl;

    public static UrlEntity of(String url) {
        //TODO: Apache Commons Validator 고려

        try {
            var __ = new URI(url).toURL();
        } catch (IllegalArgumentException | NullPointerException | MalformedURLException | URISyntaxException e) {
            throw new InvalidInputException();
        }

        UrlEntity entity = new UrlEntity();
        entity.originalUrl = url;
        return entity;
    }

    public void assignShortenedUrl(String shortenedUrl) {
        if (this.shortenedUrl != null) {
            throw new IllegalStateException("shortenedUrl already assigned: " + this.shortenedUrl);
        }
        this.shortenedUrl = shortenedUrl;
    }

}

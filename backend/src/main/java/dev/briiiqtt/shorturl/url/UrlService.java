package dev.briiiqtt.shorturl.url;

import dev.briiiqtt.shorturl.url.entity.UrlEntity;
import dev.briiiqtt.shorturl.util.Base62;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;

    public String createUrl(String req) {
        UrlEntity entity = new UrlEntity();
        entity.setUrl(req);
        urlRepository.save(entity);
        return entity.getShortenUrl();
    }

    public String readUrl(String req) {
        Optional<UrlEntity> o = urlRepository.findById(Base62.decode(req));
        if (o.isEmpty()) return null;

        UrlEntity entity = o.get();
        return entity.getUrl();
    }
}

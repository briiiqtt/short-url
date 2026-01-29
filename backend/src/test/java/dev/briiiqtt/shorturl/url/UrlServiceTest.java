package dev.briiiqtt.shorturl.url;

import dev.briiiqtt.shorturl.cache.UrlCache;
import dev.briiiqtt.shorturl.cache.UrlCacheService;
import dev.briiiqtt.shorturl.exception.InvalidInputException;
import dev.briiiqtt.shorturl.exception.UrlNotFoundException;
import dev.briiiqtt.shorturl.url.controller.CreateUrlRequest;
import dev.briiiqtt.shorturl.url.domain.UrlEntity;
import dev.briiiqtt.shorturl.url.domain.UrlRepository;
import dev.briiiqtt.shorturl.url.service.UrlService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UrlServiceTest {

    @Mock
    private UrlRepository urlRepository;

    @Mock
    private UrlCacheService urlCacheService;

    @InjectMocks
    private UrlService urlService;

    @Test
    @DisplayName("단축 URL 생성 후 걔가 DB와 캐시에 각각 저장돼야함")
    public void createUrl_validInput_storeSuccess() {
        //given
        String input = "https://google.com";
        CreateUrlRequest req = new CreateUrlRequest(input);
        UrlEntity savedEntity = UrlEntity.of(input);

        ReflectionTestUtils.setField(savedEntity, "id", 100L);
        given(urlRepository.save(any(UrlEntity.class))).willReturn(savedEntity);

        //when
        String result = urlService.createUrl(req);

        //then
        verify(urlRepository).save(any(UrlEntity.class));
        verify(urlCacheService).saveUrl(any(UrlCache.class));
    }

    @Test
    @DisplayName("단축 URL 생성시 리턴값이 정확한 Base62 인코딩 결과여야함")
    public void createUrl_validInput_returnPreciseValue() {
        //given
        String input = "https://google.com";
        CreateUrlRequest req = new CreateUrlRequest(input);
        UrlEntity savedEntity = UrlEntity.of(input);

        ReflectionTestUtils.setField(savedEntity, "id", 100L);
        given(urlRepository.save(any(UrlEntity.class))).willReturn(savedEntity);

        //when
        String result = urlService.createUrl(req);

        //then
        assertThat(result).isEqualTo("1C");
    }


    @Test
    @DisplayName("단축 URL 생성시 잘못된 형식의 입력값에 대해 예외를 반환해야함")
    public void createUrl_invalidInput_throwException() {
        //given
        String input = "hi";
        CreateUrlRequest req = new CreateUrlRequest(input);

        //when then
        assertThatThrownBy(()-> urlService.createUrl(req))
                .isInstanceOf(InvalidInputException.class)
                .hasNoCause();
    }

}

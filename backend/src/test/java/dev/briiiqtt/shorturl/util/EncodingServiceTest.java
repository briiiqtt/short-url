package dev.briiiqtt.shorturl.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EncodingServiceTest {

    private final String salt = "test-salt-string";

    @Test
    @DisplayName("Base62 인코딩,디코딩: encode, decode 결과가 일관적이어야 함")
    public void encode_decode_isPrecise() {
        //given
        long id = 10000;

        //when
        EncodingService encodingService = new CustomBase62Service(salt);
        String result = encodingService.encode(id);
        long result2 = encodingService.decode(result);

        //then
        assertThat(result2).isEqualTo(id);
    }

    /*
    salt를 추가하게돼서 정확한 값을 미리 알 수 없게 됨.
    인코딩, 디코딩의 일관성만 테스트하고, 이건 주석처리

    @Test
    @DisplayName("Base62 인코딩 정확한지: 10000을 입력하면 '2Bi' 가 반환돼야함")
    public void encode_isPrecise(){
        //given
        long id = 10000;

        //when
        EncodingService encodingService = new CustomBase62Service(salt);
        String result = encodingService.encode(id);

        //then
        assertThat(result).isEqualTo("2Bi");
    }

    @Test
    @DisplayName("Base62 디코딩 정확한지: '2Bi' 입력하면 10000 이 반환돼야함")
    public void decode_isPrecise(){
        //given
        String str = "2Bi";

        //when
        EncodingService encodingService = new CustomBase62Service(salt);
        long result = encodingService.decode(str);

        //then
        assertThat(result).isEqualTo(10000);
    }
     */

    @Test
    @DisplayName("Base62 인코딩: long 범위를 감당할 수 있어야함")
    public void encode_handlesLong() {
        //given
        long id = Long.MAX_VALUE;

        //when
        EncodingService encodingService = new CustomBase62Service(salt);
        String result = encodingService.encode(id);

        //then
        assertThat(result).isEqualTo("");
    }

}

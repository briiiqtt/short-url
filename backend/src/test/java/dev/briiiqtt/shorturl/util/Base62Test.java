package dev.briiiqtt.shorturl.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Base62Test {

    @Test
    @DisplayName("Base62 인코딩 정확한지: 10000을 입력하면 '2Bi' 가 반환돼야함")
    public void encode_isPrecise(){
        //given
        long id = 10000;

        //when
        String result = Base62.encode(id);

        //then
        assertThat(result).isEqualTo("2Bi");
    }

    @Test
    @DisplayName("Base62 디코딩 정확한지: '2Bi' 입력하면 10000 이 반환돼야함")
    public void decode_isPrecise(){
        //given
        String str = "2Bi";

        //when
        long result = Base62.decode(str);

        //then
        assertThat(result).isEqualTo(10000);
    }

    @Test
    @DisplayName("Base62 인코딩: long 범위를 감당할 수 있어야함")
    public void encode_handlesLong(){
        //given
        long id = Long.MAX_VALUE;

        //when
        String result = Base62.encode(id);

        //then
        assertThat(result).isEqualTo("aZl8N0y58M7");
    }

}

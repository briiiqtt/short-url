package dev.briiiqtt.shorturl;

import dev.briiiqtt.shorturl.common.TestContainerConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestContainerConfiguration.class)
class ShorturlApplicationTests {

    @Test
    void contextLoads() {
    }

}

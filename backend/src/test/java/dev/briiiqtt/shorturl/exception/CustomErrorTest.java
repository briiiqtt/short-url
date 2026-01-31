package dev.briiiqtt.shorturl.exception;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;

import java.util.Arrays;

public class CustomErrorTest {
    @Test
    @ServiceConnection
    void ErrorCode_Duplicate() {
        long uniqueCodeCount = Arrays.stream(CustomError.values())
                .map(CustomError::getCode)
                .distinct()
                .count();

        Assertions.assertThat(uniqueCodeCount).isEqualTo(CustomError.values().length);
    }
}

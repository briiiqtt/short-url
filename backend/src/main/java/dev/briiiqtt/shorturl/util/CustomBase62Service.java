package dev.briiiqtt.shorturl.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class CustomBase62Service implements EncodingService {
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final long OFFSET = 100_000_000L;
    private final String shuffled;

    public CustomBase62Service(@Value("${SPRING_BASE62_SALT}") String salt) {
        this.shuffled = shuffle(salt);
    }

    private String shuffle(String salt) {
        List<Character> letters = new ArrayList<>();
        for (char c : BASE62.toCharArray()) {
            letters.add(c);
        }

        long seed = salt.hashCode();
        Collections.shuffle(letters, new Random(seed));

        StringBuilder sb = new StringBuilder();
        for (char c : letters) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String encode(long num) {
        if (num == 0) return String.valueOf(shuffled.charAt(0));

        num += OFFSET;

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(shuffled.charAt((int) (num % 62)));
            num /= 62;
        }

        return sb.reverse().toString();
    }

    public long decode(String base62) {
        long result = 0;
        for (int i = 0; i < base62.length(); i++) {
            result = result * 62 + shuffled.indexOf(base62.charAt(i));
        }
        return result - OFFSET;
    }
}
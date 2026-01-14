package dev.briiiqtt.shorturl.util;

public class Base62 {
    private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String encode(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(BASE62.charAt((int) num % 62));
            num /= 62;
        }
        return sb.reverse().toString();
    }

    public static long decode(String base62) {
        long result = 0;
        for (int i = 0; i < base62.length(); i++) {
            result = result * 62 + BASE62.indexOf(base62.charAt(i));
        }
        return result;
    }
}
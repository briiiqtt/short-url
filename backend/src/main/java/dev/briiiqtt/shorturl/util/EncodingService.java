package dev.briiiqtt.shorturl.util;


public interface EncodingService {
    String encode(long value);
    long decode(String encoded);
}

package dev.briiiqtt.shorturl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String root() {
        return "this is test page and the application is running well~!";
    }
}

package com.houssem.service_b.hello;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class HelloController {


    private final RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        String serviceAResponse = restTemplate.getForObject("http://service-a/hello", String.class);
        return "Hello from Service B + message from A → " + serviceAResponse;
    }
}

package com.lim1t.csq.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class HealthCheckController {

    @GetMapping("/health/check")
    public String hello() {
        return "OK";
    }


}

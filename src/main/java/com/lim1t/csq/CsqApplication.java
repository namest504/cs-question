package com.lim1t.csq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CsqApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsqApplication.class, args);
    }

}

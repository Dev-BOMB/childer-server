package dev.childer.childerserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChilderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChilderServerApplication.class, args);
    }

    @Bean
    public ObjectMapper getObjectMapper() {

        return new ObjectMapper();

    }

}

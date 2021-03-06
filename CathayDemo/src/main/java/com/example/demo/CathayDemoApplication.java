package com.example.demo;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CathayDemoApplication {

    @Resource
    private RestTemplateBuilder builder;
	
	public static void main(String[] args) {
		SpringApplication.run(CathayDemoApplication.class, args);
	}
	
    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }
}

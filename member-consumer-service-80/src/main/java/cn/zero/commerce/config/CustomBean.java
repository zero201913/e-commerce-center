package cn.zero.commerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomBean {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

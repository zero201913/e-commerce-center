package cn.zero.commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MemberProviderApplication10000 {
    public static void main(String[] args) {
        SpringApplication.run(MemberProviderApplication10000.class, args);
    }
}

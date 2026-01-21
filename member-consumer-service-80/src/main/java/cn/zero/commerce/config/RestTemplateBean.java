package cn.zero.commerce.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBean {

    @Bean
    @LoadBalanced
    //赋予负载均衡能力，通过算法来选择服务去访问，默认是轮询算法
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

package cn.zero.commerce.config;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonRule {

    @Bean
    public IRule getRibbonRule() {
        return new RandomRule();
        //return new BestAvailableRule();
        //return new RoundRobinRule()
        //return new WeightedResponseTimeRule();
    }
}

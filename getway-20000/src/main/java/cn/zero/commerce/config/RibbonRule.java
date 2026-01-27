package cn.zero.commerce.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//gateway支持ribbon调整负载均衡策略
//@Configuration
public class RibbonRule {
    //@Bean
    public IRule getRibbonRule() {
        return new RandomRule();
        //return new BestAvailableRule();
        //return new RoundRobinRule()
        //return new WeightedResponseTimeRule();
    }
}

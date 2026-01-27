package cn.zero.commerce.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GateWayRoutesConfig {
    //配置注入路由
//    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        //lambda表达式
        return builder.routes()
                .route("member_route03", r -> r.path("/member/**").uri("http://localhost:10000")).build();
    }
//    @Bean
    public RouteLocator routeLocator1(RouteLocatorBuilder builder) {
        //lambda表达式
        return builder.routes()
                .route("member_route04", r -> r.path("/").uri("http://www.bing.com")).build();
    }
}

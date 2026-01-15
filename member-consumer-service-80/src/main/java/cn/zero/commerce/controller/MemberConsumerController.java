package cn.zero.commerce.controller;

import cn.zero.commerce.common.Result;
import cn.zero.commerce.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class MemberConsumerController {
    //更新为服务提供方的集群名称，目前有两个 Availability Zones
    //member-provider-service-10000, member-provider-service-10001
    public static final String MEMBER_PROVIDER_SERVICE_URL = "http://MEMBER-PROVIDER-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping
    public Result<Member> save(@RequestBody Member member) {
        log.info("member-consumer-service-80: 存储会员信息 {}", member);
        return restTemplate.postForObject(MEMBER_PROVIDER_SERVICE_URL + "/member", member, Result.class);
    }

    @GetMapping("/{id}")
    public Result<Member> get(@PathVariable Long id) {
        log.info("member-consumer-service-80: 获取会员信息 {}", id);
        return restTemplate.getForObject(MEMBER_PROVIDER_SERVICE_URL + "/member/" + id, Result.class);
    }
}

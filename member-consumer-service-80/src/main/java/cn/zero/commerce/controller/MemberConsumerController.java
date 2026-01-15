package cn.zero.commerce.controller;

import cn.zero.commerce.common.Result;
import cn.zero.commerce.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class MemberConsumerController {
    //后面会修改为服务调用的模块地址
    public static final String MEMBER_PROVIDER_SERVICE_URL = "http://localhost:10000";

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

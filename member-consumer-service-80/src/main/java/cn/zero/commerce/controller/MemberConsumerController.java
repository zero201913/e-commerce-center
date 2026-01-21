package cn.zero.commerce.controller;

import cn.zero.commerce.common.Result;
import cn.zero.commerce.entity.Member;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/consume")
public class MemberConsumerController {
    // 更新为服务提供方的集群名称，目前有两个 Availability Zones
    // member-provider-service-10000, member-provider-service-10001
    public static final String MEMBER_PROVIDER_SERVICE_URL = "http://MEMBER-PROVIDER-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    // discovery client
    @Resource
    private DiscoveryClient discoveryClient;

    // TODO 078
    @GetMapping("/discovery")
    @ApiOperation(value = "服务发现", notes = "获取所有注册的服务信息")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("服务名={}", service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("id={},host={},port={},uri={}", instance.getInstanceId(), instance.getHost(),
                        instance.getPort(), instance.getUri());
            }
        }
        return discoveryClient;
    }

    @ApiOperation(value = "保存会员信息", notes = "存储新的会员信息")
    @PostMapping
    public Result<Member> save(@RequestBody Member member) {
        log.info("member-consumer-service-80: 存储会员信息 {}", member);
        return restTemplate.postForObject(MEMBER_PROVIDER_SERVICE_URL + "/member", member, Result.class);
    }

    @ApiOperation(value = "获取会员信息", notes = "根据ID获取会员详细信息")
    @GetMapping("/{id}")
    public Result<Member> get(@PathVariable Long id) {
        log.info("member-consumer-service-80: 获取会员信息 {}", id);
        return restTemplate.getForObject(MEMBER_PROVIDER_SERVICE_URL + "/member/" + id, Result.class);
    }
}

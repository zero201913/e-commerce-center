package cn.zero.commerce.service;

import cn.zero.commerce.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "MEMBER-PROVIDER-SERVICE")
public interface MemberOpenFeignService {

    @GetMapping("/member/{id}")
    public Result getMemberById(@PathVariable("id") Long id);
}

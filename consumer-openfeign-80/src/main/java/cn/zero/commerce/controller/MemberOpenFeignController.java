package cn.zero.commerce.controller;

import cn.zero.commerce.common.Result;
import cn.zero.commerce.service.MemberOpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/feign")
public class MemberOpenFeignController {

    @Resource
    public MemberOpenFeignService memberOpenFeignService;

    @GetMapping("/member/{id}")
    public Result getMemberById(@PathVariable("id") Long id) {
        return memberOpenFeignService.getMemberById(id);
    }
}

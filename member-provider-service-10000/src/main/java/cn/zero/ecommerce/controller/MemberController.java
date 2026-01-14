package cn.zero.ecommerce.controller;

import cn.zero.ecommerce.common.Result;
import cn.zero.ecommerce.entity.Member;
import cn.zero.ecommerce.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {
    @Resource
    private MemberService memberService;

    // TODO 没有测试接口

    @PostMapping
    public Result save(@RequestBody Member member) {
        log.info("member-provider-service-1000: 存储会员信息 {}",member);
        int res = memberService.insertMember(member);
        if (res > 0) {
            return Result.success("插入会员成功", res);
        } else {
            return Result.error("500", "插入会员失败");
        }
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Long id) {
        log.info("member-provider-service-1000: 查询会员信息 {}",id);
        Member member = memberService.selectMemberById(id);
        if (member != null) {
            return Result.success(member);
        } else {
            return Result.error("404", "会员不存在");
        }
    }
}

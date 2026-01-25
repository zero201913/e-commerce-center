package cn.zero.commerce.controller;

import cn.zero.commerce.common.Result;
import cn.zero.commerce.entity.Member;
import cn.zero.commerce.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {
    @Resource
    private MemberService memberService;


    @PostMapping
    @ApiOperation(value = "保存会员信息", notes = "存储新的会员信息")
    public Result save(@RequestBody Member member) {
        log.info("member-provider-service-10001: 存储会员信息 {}",member);
        int res = memberService.insertMember(member);
        if (res > 0) {
            return Result.success("插入会员成功10001", res);
        } else {
            return Result.error("500", "插入会员失败");
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取会员信息", notes = "根据ID获取会员详细信息")
    public Result get(@PathVariable Long id) {

        //模拟超时5秒
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        log.info("member-provider-service-10001: 查询会员信息 {}",id);
        Member member = memberService.selectMemberById(id);
        if (member != null) {
            return Result.success("查询会员成功10001",member);
        } else {
            return Result.error("404", "会员不存在");
        }
    }
}

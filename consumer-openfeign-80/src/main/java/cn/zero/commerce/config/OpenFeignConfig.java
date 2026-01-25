package cn.zero.commerce.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class OpenFeignConfig {

    /**
     * [p-nio-80-exec-2] c.z.c.service.MemberOpenFeignService: <--- HTTP/1.1 200 (195ms)
     * [p-nio-80-exec-2] c.z.c.service.MemberOpenFeignService: connection: keep-alive
     * [p-nio-80-exec-2] c.z.c.service.MemberOpenFeignService: content-type: application/json
     * [p-nio-80-exec-2] c.z.c.service.MemberOpenFeignService: date: Sun, 25 Jan 2026 13:31:41 GMT
     * [p-nio-80-exec-2] c.z.c.service.MemberOpenFeignService: keep-alive: timeout=60
     * [p-nio-80-exec-2] c.z.c.service.MemberOpenFeignService: transfer-encoding: chunked
     * [p-nio-80-exec-2] c.z.c.service.MemberOpenFeignService:
     * [p-nio-80-exec-2] c.z.c.service.MemberOpenFeignService: {"code":"200","msg":"查询会员成功10000","data":{"id":2,"name":"李四","pwd":"e10adc3949ba59abbe56e057f20f883e","mobile":"13900139000","email":"lisi@example.com","gender":1}}
     * [p-nio-80-exec-2] c.z.c.service.MemberOpenFeignService     : [MemberOpenFeignService#getMemberById] <--- END HTTP (180-byte body)
     * @return Logger
     */

    //@Bean
    public Logger.Level getLoggerLevel() {
        return Logger.Level.FULL;
    }
}

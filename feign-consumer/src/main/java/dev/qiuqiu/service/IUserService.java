package dev.qiuqiu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 不支持下划线
@FeignClient(value = "feign-user-service")
public interface IUserService {

    @GetMapping("/user/{userId}")
    String getUserCurrentInfo(@PathVariable("userId") String userId);
}

package dev.qiuqiu.service;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 不支持下划线
@Primary
@FeignClient(name = "feign-user-service", fallback = HystrixFallBack.class)
public interface UserFeignClient {

    @GetMapping("/user/{userId}")
    String getUserCurrentInfo(@PathVariable("userId") String userId);
}

@Component
class HystrixFallBack implements UserFeignClient{

    @Override
    public String getUserCurrentInfo(String userId) {
        return "断路器打开";
    }
}

@Component
class HystrixFallBackFactory implements FallbackFactory<UserFeignClient>{

    @Override
    public UserFeignClient create(Throwable throwable) {
        return userId -> "断路器打开:" + throwable.getMessage();
    }
}

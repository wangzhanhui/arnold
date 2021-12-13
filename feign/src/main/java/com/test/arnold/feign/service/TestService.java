package com.test.arnold.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: arnold
 * @Description:
 * @Date: Created in 2021/12/11 14:18
 * @Modified By:
 */
@FeignClient(name = "eureka-client", fallbackFactory = TestServiceFallback.class)
public interface TestService {

    @GetMapping(value = "/test")
    String searchRepo();

}

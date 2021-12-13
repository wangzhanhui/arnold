package com.test.arnold.feign.service;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Auther: arnold
 * @Description:
 * @Date: Created in 2021/12/11 21:49
 * @Modified By:
 */
@Slf4j
@Service
public class TestServiceFallback implements FallbackFactory<TestService> {
    public TestService create(Throwable throwable) {
        return new TestService() {
            public String searchRepo() {
                return "error";
            }
        };
    }
}

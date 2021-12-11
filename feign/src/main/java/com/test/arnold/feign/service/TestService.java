package com.test.arnold.feign.service;

import com.test.arnold.feign.config.TestFeignServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: arnold
 * @Description:
 * @Date: Created in 2021/12/11 14:18
 * @Modified By:
 */
@FeignClient(name = "github-client", url = "https://api.github.com", configuration = TestFeignServiceConfig.class)
public interface TestService {

    @GetMapping(value = "/search/repositories")
    String searchRepo(@RequestParam("q") String queryStr);

}

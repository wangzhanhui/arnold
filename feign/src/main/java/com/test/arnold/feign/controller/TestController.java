package com.test.arnold.feign.controller;

import com.test.arnold.feign.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: arnold
 * @Description:
 * @Date: Created in 2021/12/11 14:17
 * @Modified By:
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/search/github")
    public String searchRepo(String queryStr){
        log.info("TestController.searchRepo:queryStr={}", queryStr);
        return testService.searchRepo();
    }

}

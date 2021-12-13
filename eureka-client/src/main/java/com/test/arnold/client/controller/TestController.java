package com.test.arnold.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: arnold
 * @Description:
 * @Date: Created in 2021/12/9 20:05
 * @Modified By:
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}

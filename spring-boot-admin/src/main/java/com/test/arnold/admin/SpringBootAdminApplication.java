package com.test.arnold.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: arnold
 * @Description:
 * @Date: Created in 2021/12/18 15:55
 * @Modified By:
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminApplication.class, args);
    }
}

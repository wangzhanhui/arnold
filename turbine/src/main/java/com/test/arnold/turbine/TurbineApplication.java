package com.test.arnold.turbine;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: arnold
 * @Description:
 * @Date: Created in 2021/12/11 18:35
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine // 聚合展现
@EnableHystrixDashboard // 启用 HystrixDashboard 断路器看板 相关配置
@RestController
public class TurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class, args);
    }
    @Value("${turbine.aggregator.clusterConfig}")
    private String clusterConfig;

    @GetMapping("/api/all")
    public Map<String, Object> getAllTurbines(HttpServletRequest request, @RequestParam(required = true) String innerIp,
                                              @RequestParam(required = true) String innerPort) {
        String apiUrl = request.getRequestURL().toString();
        String appBaseUrl = apiUrl.substring(0, apiUrl.lastIndexOf("/api/all"));

        List<String> clusterConfigs = Arrays.asList(clusterConfig.split(","));
        Map<String, Object> map = new HashMap<String, Object>();
        for (String k : clusterConfigs) {
            map.put(k, appBaseUrl + "/hystrix/monitor?stream=http%3A%2F%2F" + innerIp + "%3A" + innerPort
                    + "%2Fturbine.stream%3Fcluster%3D" + k + "&delay=2000&title=" + k);
        }
        return map;

    }
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}

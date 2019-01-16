package com.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * description:
 * Author:Childwanwan
 * Date:2019/1/16 15:58
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class WmsApiGateway {
    public static void main(String[] args) {
        SpringApplication.run(WmsApiGateway.class, args);
    }
}

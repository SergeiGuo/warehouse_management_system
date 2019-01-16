package com.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * description:
 * Author:Childwanwan
 * Date:2019/1/16 15:36
 */
@SpringBootApplication
@EnableEurekaServer
public class WmsRegistry {
    public static void main(String[] args) {
        SpringApplication.run(WmsRegistry.class, args);
    }
}

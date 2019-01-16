package com.wms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description:
 * Author:Childwanwan
 * Date:2019/1/16 16:31
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.wms.user.mapper")
public class WmsUserService {
    public static void main(String[] args) {
        SpringApplication.run(WmsUserService.class, args);
    }
}

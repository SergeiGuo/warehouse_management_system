package com.wms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description:
 * Author:Childwanwan
 * Date:2019/1/17 15:12
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.wms.logic.mapper")
public class WmsLogicService {
    public static void main(String[] args) {
        SpringApplication.run(WmsLogicService.class, args);
    }
}

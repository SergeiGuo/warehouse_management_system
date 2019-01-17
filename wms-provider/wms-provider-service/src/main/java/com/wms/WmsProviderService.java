package com.wms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description:
 * Author:Childwanwan
 * Date:2019/1/17 14:38
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.wms.provider.mapper")
public class WmsProviderService {
    public static void main(String[] args) {
        SpringApplication.run(WmsProviderService.class, args);
    }
}

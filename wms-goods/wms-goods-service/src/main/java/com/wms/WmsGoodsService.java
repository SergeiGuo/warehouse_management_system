package com.wms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description:
 * Author:Childwanwan
 * Date:2019/1/17 13:57
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.wms.goods.mapper")
public class WmsGoodsService {
    public static void main(String[] args) {
        SpringApplication.run(WmsGoodsService.class, args);
    }
}

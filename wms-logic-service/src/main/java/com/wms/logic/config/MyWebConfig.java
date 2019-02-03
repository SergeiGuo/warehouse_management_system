package com.wms.logic.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: MyWebConfig
 * Author:   Childwanwan
 * Date:     2019/2/2 19:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter {
    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/**").excludePathPatterns("/**/login");
        super.addInterceptors(registry);
    }
}

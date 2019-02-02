package com.wms.logic.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: GlobalExceptionHandler
 * Author:   Childwanwan
 * Date:     2019/2/2 15:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        log.error("exception handler: ", e);
        Map<String, Object> map = new HashMap<>();
        map.put("code", -9900);
        map.put("message", "系统内部异常，请联系管理员");
        return map;
    }

    @ExceptionHandler(value = IllegalAccessException.class)
    @ResponseBody
    private Map<String, Object> tokenExpired(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        log.warn("token exception: ", e);
        Map<String, Object> map = new HashMap<>();
        map.put("code", -1);
        map.put("msg", e.getMessage());
        return map;
    }
}

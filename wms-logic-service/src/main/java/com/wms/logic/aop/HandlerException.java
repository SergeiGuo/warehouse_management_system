package com.wms.logic.aop;

import com.wms.logic.exception.CheckException;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: HandlerException
 * Author:   Childwanwan
 * Date:     2019/2/1 22:03
 * Description: AOP处理异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Slf4j  //日志注解
@Aspect     //切面
@Order(5)       //执行顺序
@Component      //一般不知道是哪个分类是，就用这玩意将他注入到spring容器中
public class HandlerException {
    /**
     * 切点，找到那些方面要切
     */
    @Pointcut("execution(public * com.wms.logic.controller.*.*(..))")
    public void webException(){}

    /**
     * 环切，执行方法前后都切
     * @param proceedingJoinPoint
     * @return
     */
    @Around("webException()")
    public ResponseEntity<JSONObject> handlerControllerMethod(ProceedingJoinPoint proceedingJoinPoint){
        JSONObject jsonObject;
        try {
            long startTime = System.currentTimeMillis();
            jsonObject= (JSONObject) proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis()-startTime;
            log.info("最后花费的时间为："+ endTime);
        }catch (Throwable e){
            jsonObject= handlerException(e);
        }
        return new ResponseEntity<>(jsonObject, HttpStatus.ACCEPTED);
    }

    /**
     * 这个是判断异常的类型
     * @param throwable
     * @return
     */
    private JSONObject handlerException(Throwable throwable){
        JSONObject resultBean=new JSONObject();
        if (throwable instanceof CheckException || throwable instanceof IllegalArgumentException){
            resultBean.put("message",throwable.getLocalizedMessage());
            resultBean.put("code",1);
        }else {
            log.error("未知异常：",throwable);
            resultBean.put("message","系统内部异常，请联系管理员");
            resultBean.put("code",-99);
        }
        return resultBean;
    }
}

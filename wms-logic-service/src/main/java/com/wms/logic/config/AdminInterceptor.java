package com.wms.logic.config;

import com.wms.logic.config.redis.RedisConn;

import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: AdminInterceptor
 * Author:   Childwanwan
 * Date:     2019/2/2 19:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public class AdminInterceptor implements HandlerInterceptor {
    private RedisConn redisConn = new RedisConn();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {


        //System.out.println("第二层拦截器是不是进来了？");
/*

        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "36000");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

*/

        //System.out.println("pre: " + request.getSession().getId());

        //System.out.println("hd origin: " + request.getHeader("Origin"));


        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        //response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Allow-Headers"));
        //response.setHeader("Access-Control-Allow-Headers", "token,Accept,Origin,XRequestedWith,Content-Type,LastModified");
        //response.setHeader("Access-Control-Expose-Headers","token");
        //controller方法调用之前
        //String url = request.getRequestURI();
        //System.out.println("admin preHandler: " + url);



        String tokenHeader = request.getHeader("token");
        //System.out.println("看看能取到token不："+tokenHeader);

            //登录成功后将uesr信息存入session，以验证是否登录
            if (tokenHeader != null) {
                //System.out.println("进来了你");
                //HttpSession session = MySessionContext.getSession(tokenHeader);
                //System.out.println(session.getAttribute("user"));

                //System.out.println(request.getHeader("jsessionid"));
                //System.out.println("是否有更多的Ele:"+request.getHeaders("jsessionid").hasMoreElements());
                //System.out.println(request.getHeaders("jsessionid").toString());
                //request.getHeaders("jsessionid");

                //System.out.println("request getHeaders jsessionid :"+request.getHeaders("jsessionid"));
                //if (session != null && session.getAttribute("user") != null) {
                  //  request.setAttribute("user", session.getAttribute("user"));
                  //  return true;
               // }
                //System.out.println("tokenHeader:"+tokenHeader);
                //System.out.println("redisConn.getDataFromRedis(tokenHeader):"+redisConn.getDataFromRedis(tokenHeader));
                if (redisConn.getDataFromRedis(tokenHeader)!=null ){
                    //System.out.println("index:"+tokenHeader.indexOf(redisConn.getDataFromRedis(tokenHeader)));
                    if( redisConn.getDataFromRedis(tokenHeader).indexOf(tokenHeader)>=0){
                    //System.out.println("能返回true吗？");
                    return true;
                    }
                }

            JSONObject json = new JSONObject();
            json.put("code", -10);
            json.put("message", "请先登入");
            response.setContentType("application/json");
            response.getWriter().write(new ResponseEntity<>(json, HttpStatus.ACCEPTED).toString());
            return false;
        } else {
                return false;
        }
        //System.out.println(request.);

    }

}

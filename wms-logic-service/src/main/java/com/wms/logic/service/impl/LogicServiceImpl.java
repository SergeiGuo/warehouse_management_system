package com.wms.logic.service.impl;

import com.wms.logic.service.LogicService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: LogicServiceImpl
 * Author:   Childwanwan
 * Date:     2019/1/31 9:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class LogicServiceImpl implements LogicService {

    @Autowired
    private RestTemplate restTemplate;

    /*
         * @Author:Childwanwan
         * @Description:处理登入逻辑
         * @Para:* @param tel
        * @param password
        * @param identify
        * @param ip
         * @data:2019/1/31  18:59
         */
    @Override
    public int login(String tel,String password,String identify,String ip) {

       try {
           //接收数据解析
           int status=-1;
           switch(identify){
               case "仓库管理员" :status=0;
                   //语句
                   break; //可选
               case "系统管理员" :status=1;
                   //语句
                   break; //可选
               case "超级管理员" :status=2;
                   //语句
                   break; //可选
           }

           JSONObject jsonObject = new JSONObject();
           jsonObject.put("tel",tel);
           jsonObject.put("password",password);
           jsonObject.put("status",status);

           //登入选项，调用uersController接口
           //String url = "http://localhost:8081/user/" + id;
           String url = "http://localhost:8081/user/queryUserByTelAndPasswordAndStatus";

           ResponseEntity<String> postForEntity = restTemplate.postForEntity(url,jsonObject,String.class);
           //Response
           //System.out.println("postForEntity:"+postForEntity);
           //System.out.println("              getStatusCodeValue:"+ postForEntity.getStatusCodeValue());
           //System.out.println("              getHeaders:"+ postForEntity.getHeaders());
           //System.out.println("              getBody:"+ postForEntity.getBody());
           //System.out.println("              getHeaders:"+ postForEntity.);
           JSONObject strToJson = new JSONObject();
           strToJson = JSONObject.fromObject(postForEntity.getBody());
           //System.out.println(strToJson.get("code"));
           if(("-1").equals(strToJson.get("code").toString())){
               return -1;
           }else if (("0").equals(strToJson.get("code").toString())){
               return 0;
           }
           return 1;
       }catch (Exception e){
        return -1;
    }
       }
}

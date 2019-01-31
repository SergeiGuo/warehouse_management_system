package com.wms.logic.controller;

import com.wms.logic.service.LogicService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: LogicController
 * Author:   Childwanwan
 * Date:     2019/1/30 16:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Controller
@RequestMapping("/logic_controller")
public class LogicController {

    @Autowired
    private LogicService logicService;


    //测试
    @PostMapping("lo")
    public void test(){
        System.out.println("++++++++++++++++=test++++++++++++++");
    }

    /*
     * 用户登入验证
     *
     * */
    @PostMapping("login")
    public ResponseEntity<JSONObject> queryUserByTelephone(@RequestParam("username") String tel, @RequestParam("password") String password, @RequestParam("identify") String identify,@RequestParam("ip") String ip) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello world",1);
        try {
            //System.out.println("tel: "+tel+"password: "+password+"identify: "+identify+"ip: "+ip);
            //tel: 15797934717password: 123654789identify: 仓库管理员
            int res = logicService.login(tel,password,identify,ip);
            System.out.println(res);
            if(res>0){
                jsonObject.put("code",1);
                jsonObject.put("message","ok");
                return new ResponseEntity<>(jsonObject,HttpStatus.OK);
            }else if (res==0){
                jsonObject.put("code",0);
                jsonObject.put("message","找不到符合要求的用户,请确认账号密码和身份");
                return new ResponseEntity<>(jsonObject,HttpStatus.ACCEPTED);
            }else {
                jsonObject.put("code",-1);
                jsonObject.put("message","系统内部异常");
                return new ResponseEntity<>(jsonObject,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            jsonObject.put("code",-1);
            jsonObject.put("message","系统内部异常");
            return new ResponseEntity<>(jsonObject,HttpStatus.ACCEPTED);
        }
    }

}

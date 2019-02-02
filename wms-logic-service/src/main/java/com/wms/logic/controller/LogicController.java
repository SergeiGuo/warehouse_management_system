package com.wms.logic.controller;

import com.wms.logic.config.WebSecurityConfig;
import com.wms.logic.service.LogicService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public ResponseEntity<JSONObject> queryUserByTelephone(HttpServletResponse response, HttpServletRequest request, HttpSession session, @RequestBody JSONObject jsonParams) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello world",1);
        System.out.println("login的cookie:"+request.getCookies());
        //System.out.println("准备进入异常");
        //System.out.println(jsonParams.get("username"));
        String tel = jsonParams.get("username").toString();
        String password = jsonParams.get("password").toString();
        String identify = jsonParams.get("identify").toString();
        String ip = jsonParams.get("ip").toString();
        //int i = 10/0;
        try {
            //System.out.println("tel: "+tel+"password: "+password+"identify: "+identify+"ip: "+ip);
            //tel: 15797934717password: 123654789identify: 仓库管理员
            int res = logicService.login(tel,password,identify,ip);
            //System.out.println(res);
            //int res =1;
            if(res>0){
                response.setHeader("token", request.getSession().getId());
                session.setAttribute(WebSecurityConfig.SESSION_KEY,tel);
                //System.out.println(session.getAttribute(WebSecurityConfig.SESSION_KEY));
                //System.out.println("login中的sessionID:"+session.getId());
                jsonObject.put("code",1);
                jsonObject.put("message","ok");
                jsonObject.put("data",request.getSession().getId());
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

    @GetMapping("get_warehouse_message")
    public ResponseEntity<JSONObject> getWarehouseMessage(HttpServletRequest request,HttpSession session, @RequestParam("telephone") String tel) {
        //System.out.println("get_warehouse_message的cookie:"+request.getCookies());
        //System.out.println("get_warehouse_message"+tel);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello warehouseManager",1);
        System.out.println("获取数据中的sessionID:"+session.getId());
        return new ResponseEntity<>(jsonObject,HttpStatus.OK);
    }

}

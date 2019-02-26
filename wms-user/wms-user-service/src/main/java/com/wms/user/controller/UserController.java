package com.wms.user.controller;

import com.wms.user.pojo.User;
import com.wms.user.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * description:
 * Author:Childwanwan
 * Date:2019/1/16 19:15
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("list")
    public ResponseEntity<User> queryAllUser() {
        User list = userService.queryAllUser();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }

    @ResponseBody
    @RequestMapping(value = "queryUserByTelAndPasswordAndStatus",method = RequestMethod.POST)
    public ResponseEntity<JSONObject> queryUserByTelAndPasswordAndStatus(@RequestBody JSONObject jsonObject) {
        //System.out.println(jsonObject);
        //System.out.println("tel:"+jsonObject.get("tel"));
        try {
        List<User> list = userService.queryUserByTelAndPasswordAndStatus(jsonObject.get("tel").toString(),jsonObject.get("password").toString(),Integer.parseInt(jsonObject.get("status").toString()));
        JSONObject result = new JSONObject();
        if (list.size() <= 0) {
            jsonObject.put("code",0);
            jsonObject.put("message","没有相应的用户");
            //System.out.println("没有相应的用户");
            //new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.ok(jsonObject);
        }
        jsonObject.put("code",1);
        jsonObject.put("data",list);
        return ResponseEntity.ok(jsonObject);
        }catch (Exception e){
            jsonObject.put("code",-1);
            jsonObject.put("message","服务器异常");
            return ResponseEntity.ok(jsonObject);
        }
    }
}

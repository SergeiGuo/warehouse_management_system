package com.wms.goods.controller;


import com.wms.goods.pojo.Goods;
import com.wms.goods.service.GoodsService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author childwanwan
 * @since 2019-01-17
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping("list")
    public ResponseEntity<Goods> queryAllUser() {
        Goods list = goodsService.queryGoodsById();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }

    @ResponseBody
    @RequestMapping(value = "queryGoodsByPage",method = RequestMethod.GET)
    public ResponseEntity<JSONObject> queryGoodsByPage(@RequestParam("pageSize") int pageSize,@RequestParam("currentPage") int currentPage,@RequestParam("warehouseId") int warehouseId){
        // Integer pageSize, @RequestParam("currentPage") Integer currentPage
        System.out.println("queryGoodsByPage goods服务进来了:"+pageSize+" "+currentPage);
        JSONObject jsonObject1 = new JSONObject();
        try {
            List<Goods> list = goodsService.queryGoodsByPage(pageSize, currentPage,String.valueOf(warehouseId));
            if (list!=null){
                jsonObject1.put("code", 1);
                jsonObject1.put("data", list);
                jsonObject1.put("message", "OK");
            }else {
                jsonObject1.put("code", 0);
                jsonObject1.put("message", "没查到响应的数据");
            }
        }catch (Exception e){
            jsonObject1.put("code", -1);
            jsonObject1.put("message", "系统内部异常");
        }
        //System.out.println(jsonObject1);
        return ResponseEntity.ok(jsonObject1);
    }
}


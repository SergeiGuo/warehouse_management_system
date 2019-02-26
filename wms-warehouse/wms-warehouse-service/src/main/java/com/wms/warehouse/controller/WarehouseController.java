package com.wms.warehouse.controller;


import com.wms.warehouse.pojo.Warehouse;
import com.wms.warehouse.service.WarehouseService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;
    @GetMapping("list")
    public ResponseEntity<Warehouse> queryAllUser() {
        Warehouse list = warehouseService.queryUserbyId();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }

    @ResponseBody///warehouse/getWarehouseByTel
    @RequestMapping(value = "getWarehouseByTel",method = RequestMethod.GET)
    public ResponseEntity<JSONObject> getWarehouseByTel(@RequestParam("tel") String tel){

        //System.out.println("getWarehouseByTel :"+tel);

		JSONObject jsonObject = new JSONObject();
		Warehouse warehouse = warehouseService.getWarehouseByTel(tel);

		if (warehouse!=null){
			jsonObject.put("code",1);
			jsonObject.put("data",warehouse);
		}else{
			jsonObject.put("code",-1);
			jsonObject.put("message","查询的仓库不存在");
		}
        return ResponseEntity.ok(jsonObject);
    }
}


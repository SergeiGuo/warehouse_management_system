package com.wms.logic.service;

import com.wms.goods.pojo.Goods;
import com.wms.warehouse.pojo.Warehouse;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LogicService
 * Author:   Childwanwan
 * Date:     2019/1/31 9:47
 * Description: LogicServiceInterface
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public interface LogicService {
    public Map<String,Object> login(String tel, String password, String identify, String ip);

    public JSONObject getGoodsMessage(int pageSize, int currentPage,String warehouseId);

    //根据登入者的电话，来找相应的仓库信息
    public Warehouse  getWarehouseByTel(String tel);
}

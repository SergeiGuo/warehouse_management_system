package com.wms.logic.service;

import com.wms.goods.pojo.Goods;
import net.sf.json.JSONObject;

import java.util.List;

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
    public int login(String tel,String password,String identify,String ip);

    public JSONObject getGoodsMessage(int pageSize, int currentPage,String warehouseId);
}

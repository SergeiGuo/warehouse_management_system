package com.wms.warehouse.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.warehouse.pojo.Warehouse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author childwanwan
 * @since 2019-01-17
 */
public interface WarehouseService extends IService<Warehouse> {
    public Warehouse queryUserbyId();
    public Warehouse getWarehouseByTel(String tel);
}

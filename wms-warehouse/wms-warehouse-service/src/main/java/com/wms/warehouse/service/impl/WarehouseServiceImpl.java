package com.wms.warehouse.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.warehouse.mapper.WarehouseMapper;
import com.wms.warehouse.pojo.Warehouse;
import com.wms.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author childwanwan
 * @since 2019-01-17
 */
@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;
    public Warehouse queryUserbyId(){
        return warehouseMapper.selectById("1");
    }
}

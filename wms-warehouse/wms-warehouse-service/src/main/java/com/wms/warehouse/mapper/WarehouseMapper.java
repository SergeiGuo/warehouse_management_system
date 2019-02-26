package com.wms.warehouse.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.warehouse.pojo.Warehouse;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author childwanwan
 * @since 2019-01-17
 */
public interface WarehouseMapper extends BaseMapper<Warehouse> {

	@Select("select * from tbl_warehouse where id=(select id from tbl_user_bind_warehouse where user_id =(select id from tbl_user where telephone=#{tel}))")
	public Warehouse selectWarehouseByTel(String tel);

}

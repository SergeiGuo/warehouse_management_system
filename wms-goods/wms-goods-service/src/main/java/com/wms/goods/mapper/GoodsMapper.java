package com.wms.goods.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.goods.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author childwanwan
 * @since 2019-01-17
 */
public interface GoodsMapper extends BaseMapper<Goods> {
	@Select("select * from tbl_goods where id in (select goods_id from tbl_warehouse_goods where tbl_warehouse_goods.warehouse_id = #{warehouse_id}) LIMIT ${first},${last}")
	List<Goods> queryGoodsByPage(int first, int last,String warehouse_id);

}

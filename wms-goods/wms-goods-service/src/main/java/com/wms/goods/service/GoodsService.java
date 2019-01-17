package com.wms.goods.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.goods.pojo.Goods;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author childwanwan
 * @since 2019-01-17
 */
public interface GoodsService extends IService<Goods> {

    public Goods queryGoodsById();
}

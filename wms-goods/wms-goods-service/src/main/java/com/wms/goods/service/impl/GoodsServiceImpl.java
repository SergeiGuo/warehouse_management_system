package com.wms.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.goods.mapper.GoodsMapper;
import com.wms.goods.pojo.Goods;
import com.wms.goods.service.GoodsService;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    public Goods queryGoodsById(){
        return goodsMapper.selectById("1");
    }
}

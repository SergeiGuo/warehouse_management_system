package com.wms.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.Condition;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.goods.mapper.GoodsMapper;
import com.wms.goods.pojo.Goods;
import com.wms.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /*
		* @Author:Childwanwan
		* @Description:分页查询所有的物品
		* @Para:* @param pageSize
	   * @param currentPage
		* @data:2019/2/17  22:25
		*/
    @Override
    public List<Goods> queryGoodsByPage(int pageSize, int currentPage,String warehouseId) {
        //System.out.println("进来了:"+pageSize+" "+currentPage);
        //new QueryWrapper<Goods>().eq(,)
		//(currentPage-1)*pageSize,pageSize
		//System.out.println("我自己的查询语句结果："+goodsMapper.queryGoodsByPage((currentPage-1)*pageSize,pageSize,"1"));

        //IPage<Goods> goodsIPage= goodsMapper.selectPage(new Page<Goods>(currentPage, pageSize), null);
        //goodsIPage.setSize(2);
        //goodsIPage.setCurrent(3);
        //System.out.println(goodsIPage.getRecords().get(1));
        //goodsIPage.getRecords().forEach(System.out::println);

        /*List<Goods> list = new ArrayList<Goods>();
        for (int i = 0;i<goodsIPage.getRecords().size();i++){

            //goodsIPage.getRecords().get(i).getCreateTime().getTime();
            list.add(goodsIPage.getRecords().get(i));
        }*/
		List<Goods> list = goodsMapper.queryGoodsByPage((currentPage-1)*pageSize,pageSize,warehouseId);
        //System.out.println(list);


        //分页查询
        //goodsMapper.queryGoodsByPage(pageSize*currentPage-1,pageSize);
       // System.out.println(goodsMapper.queryGoodsByPage(pageSize*currentPage-1,pageSize));

        return list;
    }
}

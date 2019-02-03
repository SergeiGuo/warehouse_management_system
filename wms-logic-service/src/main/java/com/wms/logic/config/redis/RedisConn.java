package com.wms.logic.config.redis;

import redis.clients.jedis.Jedis;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: RedisConn
 * Author:   Childwanwan
 * Date:     2019/2/3 11:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public class RedisConn {
    public String getDataFromRedis(String key){
        Jedis jedis = new Jedis("120.78.132.185", 6379);
        return jedis.get(key);
    }
    public boolean setDataIntoRedis(String key,String value){
        Jedis jedis = new Jedis("120.78.132.185", 6379);
        if (jedis.get(key)!=null)return true;
         if ("OK".equals(jedis.set(key,value))){
             return true;
         }else return false;
    }
}

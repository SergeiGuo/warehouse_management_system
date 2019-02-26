package com.wms.logic.service.impl;

import com.wms.goods.pojo.Goods;
import com.wms.logic.config.redis.RedisConn;
import com.wms.logic.service.LogicService;
import com.wms.warehouse.pojo.Warehouse;
import net.sf.json.JSONObject;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: LogicServiceImpl
 * Author:   Childwanwan
 * Date:     2019/1/31 9:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Service
public class LogicServiceImpl implements LogicService {

	@Autowired
	private RestTemplate restTemplate;

	/*
		 * @Author:Childwanwan
		 * @Description:处理登入逻辑
		 * @Para:* @param tel
		* @param password
		* @param identify
		* @param ip
		 * @data:2019/1/31  18:59
		 */
	@Override
	public Map<String, Object> login(String tel, String password, String identify, String ip) {

		Map<String, Object> map = new HashMap<>();
		try {
			//接收数据解析
			int status = -1;
			switch (identify) {
				case "仓库管理员":
					status = 0;
					//语句
					break; //可选
				case "系统管理员":
					status = 1;
					//语句
					break; //可选
				case "超级管理员":
					status = 2;
					//语句
					break; //可选
			}

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("tel", tel);
			jsonObject.put("password", password);
			jsonObject.put("status", status);

			//登入选项，调用uersController接口
			//String url = "http://localhost:8081/user/" + id;
			String url = "http://localhost:8081/user/queryUserByTelAndPasswordAndStatus";

			ResponseEntity<String> postForEntity = restTemplate.postForEntity(url, jsonObject, String.class);
			//Response
			//System.out.println("postForEntity:"+postForEntity);
			//System.out.println("              getStatusCodeValue:"+ postForEntity.getStatusCodeValue());
			//System.out.println("              getHeaders:"+ postForEntity.getHeaders());
			//System.out.println("              getBody:"+ postForEntity.getBody());
			//System.out.println("              getHeaders:"+ postForEntity.);
			JSONObject strToJson = new JSONObject();
			strToJson = JSONObject.fromObject(postForEntity.getBody());
			//System.out.println(strToJson.get("code"));
			if (("-1").equals(strToJson.get("code").toString())) {
				map.put("code", -1);
				return map;
			} else if (("0").equals(strToJson.get("code").toString())) {
				map.put("code", 0);
				return map;
			}
			//System.out.println("能接到登入的返回数据吗："+strToJson.get("data"));
			RedisConn redisConn = new RedisConn();
			redisConn.setDataIntoRedis(tel, "用户:" + tel);
			map.put("code", 1);
			map.put("data", strToJson.get("data"));
			return map;
		} catch (Exception e) {
			map.put("code", -1);
			return map;
		}
	}

	/*
	  * @Author:Childwanwan
	  * @Description:分页查询所有商品信息
	  * @Para:* @param pageSize
	 * @param currentPage
	  * @data:2019/2/17  22:15
	  */
	@Override
	public JSONObject getGoodsMessage(int pageSize, int currentPage, String warehouseId) {
		//System.out.println("进来了吗");

		String url = "http://localhost:8083/goods/queryGoodsByPage";
		Map<String, Object> params = new HashMap<>();
		params.put("pageSize", pageSize);
		params.put("currentPage", currentPage);
		params.put("warehouseId", warehouseId);
		//JSONObject jsonObject = new JSONObject();
		try {
			ResponseEntity<String> getForEntity = restTemplate.getForEntity(url + "?pageSize={pageSize}&currentPage={currentPage}&warehouseId={warehouseId}", String.class, params);
			//Response
			//System.out.println("postForEntity:"+postForEntity);
			//System.out.println("              getStatusCodeValue:"+ postForEntity.getStatusCodeValue());
			//System.out.println("              getHeaders:"+ postForEntity.getHeaders());
			//System.out.println("              getBody:"+ postForEntity.getBody());
			//System.out.println("              getHeaders:"+ postForEntity.);
			//System.out.println(getForEntity.getBody());
			JSONObject strToJson = new JSONObject();
			strToJson = JSONObject.fromObject(getForEntity.getBody());
			//System.out.println(strToJson.get("data"));
			//System.out.println(strToJson.get("code"));
			if (("1").equals(strToJson.get("code").toString())) {
				return strToJson;//这里应该返回相应的数据
			} else  {
				return null;
			}

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Warehouse getWarehouseByTel(String tel) {
		String url = "http://localhost:8082/warehouse/getWarehouseByTel";
		Map<String, Object> params = new HashMap<>();
		params.put("tel", tel);
		try {
			ResponseEntity<String> getForEntity = restTemplate.getForEntity(url + "?tel={tel}", String.class, params);
			//Response
			//System.out.println("postForEntity:"+postForEntity);
			//System.out.println("              getStatusCodeValue:"+ postForEntity.getStatusCodeValue());
			//System.out.println("              getHeaders:"+ postForEntity.getHeaders());
			//System.out.println("              getBody:"+ postForEntity.getBody());
			//System.out.println("              getHeaders:"+ postForEntity.);
			//System.out.println(getForEntity.getBody());
			JSONObject strToJson = new JSONObject();
			strToJson = JSONObject.fromObject(getForEntity.getBody());
			//System.out.println(strToJson.get("data"));
			if (("1").equals(strToJson.get("code").toString())) {
				JSONObject jsonObject = JSONObject.fromObject(strToJson.get("data").toString());
				//System.out.println(jsonObject);
				//System.out.println(jsonObject.get("id"));
				Warehouse warehouse = new Warehouse();
				warehouse.setId(jsonObject.get("id").toString())
						.setAddress(jsonObject.get("address").toString())
						.setName(jsonObject.get("name").toString())
						.setRepertory((int) jsonObject.get("repertory"))
						.setSpace((int) jsonObject.get("space"));
				//System.out.println(warehouse);
				return warehouse;//这里应该返回相应的数据
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}


}

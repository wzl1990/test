package com.lenovo.rm.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lenovo.rm.entity.Demo;
import com.lenovo.rm.util.StringUtil;



/**
 * 反序列化JSON格式数据
 * @author zhenglong.wei
 *
 */
public class JacksonSerailizerImpl implements SubscribeSerializer{

	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public Demo deserail(String data) throws Exception {
		if(!StringUtil.isEmpty(data)){
			Demo subscribe = mapper.readValue(data.toString(), Demo.class);
			return subscribe;
		}else{
			return null;
		}
	}

	@Override
	public String serail(Demo subscribe) throws Exception {
		return mapper.writeValueAsString(subscribe);
	}
	 

}
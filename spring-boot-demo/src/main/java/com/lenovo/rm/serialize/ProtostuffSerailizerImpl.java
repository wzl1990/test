package com.lenovo.rm.serialize;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.lenovo.rm.entity.Demo;


/**
 * 反序列化JSON格式数据
 * @author zhenglong.wei
 *
 */
public class ProtostuffSerailizerImpl implements ProtostuffSerializer {

	private RuntimeSchema<Demo> schema = RuntimeSchema.createFrom(Demo.class);

	@Override
	public Demo deserail(byte[] data) {
		 Demo subscribe = schema.newMessage();
         ProtostuffIOUtil.mergeFrom(data, subscribe, schema);
         return subscribe;
	}

	@Override
	public byte[] serail(Demo subscribe){
		byte[] bytes = ProtostuffIOUtil.toByteArray(subscribe, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
		return bytes;
	}
	 

}
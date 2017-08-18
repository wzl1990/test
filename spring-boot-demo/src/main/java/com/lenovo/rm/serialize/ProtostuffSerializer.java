package com.lenovo.rm.serialize;

import com.lenovo.rm.entity.Demo;

/**
 * 将服务端传来的user数据反序列化
 * 
 * @author zhenglong.wei
 *
 */
public interface ProtostuffSerializer {

    /**
     * 反序列化
     * 
     * @param data
     * @return
     */
    public Demo deserail(byte[] data);
    
    /**
     * 序列化
     * 
     * @param data
     * @return
     */
    public byte[] serail(Demo subscribe);
}

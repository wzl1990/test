package com.lenovo.rm.serialize;

import com.lenovo.rm.entity.Demo;
import sun.jvm.hotspot.code.DeoptimizationBlob;

/**
 * 将服务端传来的user数据反序列化
 * 
 * @author zhenglong.wei
 *
 */
public interface SubscribeSerializer {

    /**
     * 反序列化
     * 
     * @param data
     * @return
     * @throws Exception
     */
    public Demo deserail(String userData) throws Exception;
    
    /**
     * 序列化
     * 
     * @param data
     * @return
     * @throws Exception
     */
    public String serail(Demo subscribe) throws Exception;
}

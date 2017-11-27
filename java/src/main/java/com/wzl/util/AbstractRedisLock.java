//package com.wzl.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.opc.shop.support.service.base.util.SpringBeanUtil;
//
///**
// *
// * reids 分布式锁
// * @author zhenglong
// * @since 25 十一月 2017
// */
//public abstract class AbstractRedisLock<T> {
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    /**
//     * key前缀
//     */
//    private static final String PREFIX = "lock:";
//
//    /**
//     * redis key
//     */
//    private String redisKey = null;
//
//    /**
//     * redis value
//     */
//    private String redisValue = null;
//
//    /**
//     * 锁的过期时间（秒），默认30秒，防止线程获取锁后挂掉无法释放锁
//     */
//    private int lockExpire = 30;
//
//    /**
//     * 尝试加锁超时时间（毫秒），默认为expire的1.2倍
//     */
//    private int tryTimeout = lockExpire * 1200;
//
//    /**
//     * 尝试加锁次数计数器
//     */
//    private long tryCounter = 0;
//
//    /**
//     * 加锁成功标记
//     */
//    private boolean success;
//
//    /**
//     * AbstractRedisLock
//     *
//     * @param lockKey
//     */
//    public AbstractRedisLock(String lockKey) {
//        this.redisKey = PREFIX + lockKey;
//        this.redisValue = lockKey + "-" + System.currentTimeMillis() + "-" + this.random(10000);
//    }
//
//    /**
//     * AbstractRedisLock
//     *
//     * @param lockKey
//     * @param lockExpire
//     */
//    public AbstractRedisLock(String lockKey, int lockExpire) {
//        this(lockKey);
//        this.lockExpire = lockExpire;
//        this.tryTimeout = lockExpire * 1200;
//    }
//
//    protected abstract boolean doExecute();
//
//    public T execute() {
//        T t = null;
//        long nowTime = System.currentTimeMillis();
//        try{
//            tryLock();
//            doExecute();
//        }catch (Exception e){
//            logger.error("执行失败={}", e);
//        } finally{
//            release();
//        }
//        return t;
//    }
//
//
//    /***
//     * 获取锁
//     */
//    public void tryLock() {
//       long  startMillis = System.currentTimeMillis();
//        if (!lock()) {
//            do {
//                if (System.currentTimeMillis() - startMillis >= tryTimeout) {
//                    throw new RuntimeException("尝试加锁超时" + tryTimeout + "ms");
//                }
//                try {
//                    Thread.sleep((int) (this.random(200)));
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            while (!lock());
//        }
//    }
//
//    /**
//     *  释放锁
//     */
//    public void release() {
//        if (success) {
//            String value = SpringBeanUtil.getBean(JedisClient.class).get(redisKey);
//            if (redisValue.equals(value)) {
//                SpringBeanUtil.getBean(JedisClient.class).del(redisKey);
//                logger.debug("已释放锁：{}", redisValue);
//            }
//        }
//    }
//
//    /**
//     * 加锁
//     * @return 加锁是否成功
//     */
//    private boolean lock() {
//        tryCounter++;
//        success = SpringBeanUtil.getBean(JedisClient.class).setnx(redisKey, redisValue)==1L?true:false;
//        SpringBeanUtil.getBean(JedisClient.class).expire(redisKey,lockExpire);
//        if (success) {
//            logger.debug("加锁成功：尝试{}次", tryCounter);
//        }
//        return success;
//    }
//
//    private int random(int max) {
//        return (int) (Math.random() * max);
//    }
//}

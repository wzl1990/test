package com.wzl.loadbalance;

/**
 * @author zhenglong.wei
 * @create 2017-07-14 18:59
 */
public class Test {
    private static  final long twepoch = 1288834974657L;
    private static final long workerIdBits = 5L;
    private static final long datacenterIdBits = 5L;
    private static final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private static final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    private static final long sequenceBits = 12L;
    private static final long workerIdShift = sequenceBits;
    private static final long datacenterIdShift = sequenceBits + workerIdBits;
    private static final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private static final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public static void main(String[] args) {
      System.out.println(maxWorkerId);
      System.out.println(maxDatacenterId);
      System.out.println(-1L << workerIdBits);
      System.out.println(-1L^-32L);
      System.out.println();
        int a=-1;
        int b=-32;
        System.out.println("a 和b 与的结果是："+(a^b));
    }

}

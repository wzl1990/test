package com.wzl.nio.course.chapter01;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 25 十月 2017
 */
public class ChannelTest {



    @Test
    public  void test1() throws  Exception{
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("/Users/zhenglong/Downloads/wikiaddress", "rw");
            FileChannel inChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buf.flip();
                while(buf.hasRemaining()){
                    System.out.print((char) buf.get());
                }
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            aFile.close();
        }
    }

    @Test
    public  void test2()throws  Exception{
        RandomAccessFile fromFile=null;
        RandomAccessFile toFile=null;

        try {
             fromFile = new RandomAccessFile("/Users/zhenglong/Downloads/wikiaddress", "rw");
             FileChannel      fromChannel = fromFile.getChannel();

             toFile = new RandomAccessFile("/Users/zhenglong/Downloads/wikiaddress2", "rw");
             FileChannel      toChannel = toFile.getChannel();

            long position = 0;
            long count = fromChannel.size();

            fromChannel.transferTo(position, count, toChannel);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            toFile.close();
            fromFile.close();

        }
    }

    @Test
    public void test3(){
        //输入 ab/bdeer/eb/ewe/bwewe; 输出 wewe
        String inpurt="ab/bdeer/eb/ewe/bwewe";

        int index=inpurt.indexOf("/b");
        //System.out.println(index);

        //System.out.println(inpurt.substring(index+2,inpurt.length()));
       // System.out.println(match(inpurt));
       // System.out.println(match("sdsd"));
        System.out.println(match("/b"));


    }

    private  String match(String inpurt){
        if(inpurt==null){
            return null;
        }
        if(inpurt.indexOf("/b")<0){
            return inpurt;
        }
        int index=inpurt.indexOf("/b");

        return match(inpurt.substring(index+2,inpurt.length()));

    }

}

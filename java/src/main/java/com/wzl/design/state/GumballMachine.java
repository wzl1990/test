package com.wzl.design.state;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 03 十一月 2017
 */
public class GumballMachine {

     final static int SOLD_OUT=0;

     final static int NO_QUANTER=1;

     final static int HAS_QUANTER=2;

     final static int SOLD=3;

    private int count=0;

    private int state=SOLD_OUT;

    public  void setState(int state){
        this.state=state;
    }


    public GumballMachine(int count){
        this.count=count;
        if(count>0){
            this.state=NO_QUANTER;
        }
    }

    public void insertQunater(){
      if(state==HAS_QUANTER){
          System.out.println("已经有硬币了");
      }else  if(state==NO_QUANTER){
          System.out.println("请投币");
          state=HAS_QUANTER;
      }else if(state==SOLD){
          System.out.println("已经售完了");
      }else if(state==NO_QUANTER){
          System.out.println("请投币");
      }
    }


    public void rejectQunater(){

    }

    public void turnck(){

    }

    public void dispense(){

    }




}

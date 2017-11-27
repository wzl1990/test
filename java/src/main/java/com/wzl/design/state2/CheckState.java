package com.wzl.design.state2;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 03 十一月 2017
 */
public class CheckState implements State {

    Room room;

    public  CheckState(Room room){
        this.room=room;
    }
    @Override
    public void bookRoom() {
        System.out.println("已经入住，不能预定");
    }

    @Override
    public void unsubscribeRoom() {
        System.out.println("已经入住，不能退订");
    }

    @Override
    public void checkInRoom() {
        System.out.println("已经入住，不能入住了");
    }

    @Override
    public void checkoutRoom() {
        System.out.println("退房");
        room.status=Room.idle;
    }
}

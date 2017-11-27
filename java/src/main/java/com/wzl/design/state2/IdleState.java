package com.wzl.design.state2;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 03 十一月 2017
 */
public class IdleState implements State {


    Room room;

    public  IdleState(Room room){
        this.room=room;
    }
    @Override
    public void bookRoom() {
        System.out.println("预定房间");
        room.status=Room.book;
    }

    @Override
    public void unsubscribeRoom() {
        System.out.println("没有预定，无法退订");
    }

    @Override
    public void checkInRoom() {
        System.out.println("没有预定，无法入住");
    }

    @Override
    public void checkoutRoom() {
        System.out.println("没有预定，无法退房");
    }
}

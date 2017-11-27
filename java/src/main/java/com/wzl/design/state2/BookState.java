package com.wzl.design.state2;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 03 十一月 2017
 */
public class BookState implements State {

    Room room;

    public  BookState(Room room){
        this.room=room;
    }

    @Override
    public void bookRoom() {
        System.out.println("已经预定，不能预定");
    }

    @Override
    public void unsubscribeRoom() {
        System.out.println("退订");
        room.status=Room.idle;
    }

    @Override
    public void checkInRoom() {
        System.out.println("入住");
        room.status=Room.checkin;
    }

    @Override
    public void checkoutRoom() {
        System.out.println("没有入住，不能退房");
    }
}

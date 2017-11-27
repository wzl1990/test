package com.wzl.design.state2;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 03 十一月 2017
 */
public class Test {
    public static void main(String[] args) {
        Room room=new Room();

        room.bookRoom();
        System.out.println(room.status);
        room.checkoutRoom();
        System.out.println(room.status);
        room.checkInRoom();
        System.out.println(room.status);

    }
}

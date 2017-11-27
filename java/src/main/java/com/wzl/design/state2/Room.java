package com.wzl.design.state2;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 03 十一月 2017
 */
public class Room {

    int status=0;

    final static int idle=0;
    final static int book=1;
    final static int checkin=2;

    State state;

    public  Room(){
        state=new IdleState(this);
    }

    public void bookRoom() {
        state.bookRoom();
    }

    public void unsubscribeRoom() {
        state.unsubscribeRoom();
    }

    public void checkInRoom() {
        state.checkInRoom();
    }

    public void checkoutRoom() {
        state.checkoutRoom();
    }


}

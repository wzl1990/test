package com.wzl.design.state2;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 03 十一月 2017
 */
public interface State {

    void bookRoom();

    void unsubscribeRoom();


    void checkInRoom();

    void checkoutRoom();

}

package com.wzl.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 27 十月 2017
 */
public class FilmTelevisionMenu implements TelevisionMenu {

    List<MenuItem> menuItems=null;

    public FilmTelevisionMenu(){
        menuItems=new ArrayList<>();
        menuItems.add(new MenuItem("cctv1",1,"中1"));
        menuItems.add(new MenuItem("cctv2",2,"中2"));
        menuItems.add(new MenuItem("cctv3",3,"中3"));
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
}

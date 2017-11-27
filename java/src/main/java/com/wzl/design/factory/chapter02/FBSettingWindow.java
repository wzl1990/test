package com.wzl.design.factory.chapter02;

import java.util.ArrayList;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 05 十一月 2017
 */
public class FBSettingWindow {

    private String title; //窗口标题
    //定义一个ArrayList来存储所有功能键
    private ArrayList<FunctionButton> functionButtons = new ArrayList<FunctionButton>();

    public FBSettingWindow(String title) {
        this.title = title;
    }

    public void setTitle(String title) { this.title = title;
    }
    public String getTitle() { return this.title;
    }
    public void addFunctionButton(FunctionButton fb) { functionButtons.add(fb);
    }
    public void removeFunctionButton(FunctionButton fb) { functionButtons.remove(fb);
    }

    //显示窗口及功能键
    public void display() {
System.out.println("显示窗口:" + this.title); System.out.println("显示功能键:");
for (Object obj : functionButtons) {
        System.out.println(((FunctionButton)obj).getName()); }
System.out.println("------------------------------"); }

}


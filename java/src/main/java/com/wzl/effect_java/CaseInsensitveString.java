package com.wzl.effect_java;

/**
 * TODO completion javadoc.
 *
 * @author zhenglong
 * @since 16 十月 2017
 */
public final  class CaseInsensitveString {

    private final  String s;

    public  CaseInsensitveString(String s){
        this.s=s;
    }

    @Override
    public  boolean equals(Object object){
        if(object instanceof  CaseInsensitveString){
           return s.equalsIgnoreCase(((CaseInsensitveString) object).s);
        }else  if(object instanceof String ){
          return   ((String) object).equalsIgnoreCase(s);
        }
        return false;
    }

    public static void main(String[] args) {
        CaseInsensitveString ss=new CaseInsensitveString("Polish");
        String p="polish";
        System.out.println(ss.equals(p));
        System.out.println(ss.toString());
        System.out.println(p.equals(ss.toString()));
    }
}

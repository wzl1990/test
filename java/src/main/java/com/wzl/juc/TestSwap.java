package com.wzl.juc;

public class TestSwap {
	
	public static void main(String[] args) {
		Integer aInteger=555;
		Integer bInteger=666;
		new TestSwap().swap(aInteger, bInteger);
		System.out.println(aInteger);
		System.out.println(bInteger);
		int num=200;
		String a="200";
		new TestSwap().set(num);
		new TestSwap().set(a);
		System.out.println(num);
		System.out.println(a);
	}

	public  void swap(Integer a,Integer b){
		Integer c=a;
		 a=b;
		 b=c;
	}
	
	public  void set(int a){
	a=100;
	}
	
	public  void set(String a){
		a="100";
		}
	
	
}

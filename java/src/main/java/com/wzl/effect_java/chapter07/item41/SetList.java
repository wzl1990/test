// What does this program print? - Page 194
package com.wzl.effect_java.chapter07.item41;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetList {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();

		for (int i = -3; i < 3; i++) {
			set.add(i);
			list.add(i);
		}

		for (int i = 0; i <3 ; i++) {
			set.remove(i);
			list.remove(i);
		}

		System.out.println(set + " " + list);


		for (int i = 0, size=size(); i <size ; i++) {
			System.out.println(i);
		}
	}

	private static int size(){
		System.out.println("cccc");
		return 3;
	}
}
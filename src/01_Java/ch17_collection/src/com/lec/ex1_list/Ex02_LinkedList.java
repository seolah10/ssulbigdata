package com.lec.ex1_list;

import java.util.LinkedList;

public class Ex02_LinkedList {

		public static void main(String[] args) {
			
				LinkedList<String> linkedList = new LinkedList<String>();
				linkedList.add("str0");
				linkedList.add("str1");
				linkedList.add("str2");
				linkedList.add(1, "11111");
				
				System.out.println(linkedList);
				
				for(int i=0 ; i<linkedList.size() ; i++) { 
						System.out.println(linkedList.get(i));
				
				linkedList.remove("1111");
				linkedList.clear();
				System.out.println(linkedList.isEmpty() ? "ºñ¿öÁü" : "¾Èºñ¿öÁü");
				}
		}
}

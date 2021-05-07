package com.lec.ex4_object;

public class Ex03_GoodsCustomersMain {

		public static void main(String[] args) {
			
			Goods s1 = new Goods ("a001", "새우깡", 1100, 10);
			Goods s2 = new Goods ("a002", "버터칩", 2000, 10);
			Goods s3 = new Goods ("a003", "맛있는우유", 850, 20);
			
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			
			
			Customer c1 = new Customer("010-9999-9999", "이익준");
			Customer c2 = new Customer("010-8888-8888", "채송화");
			Customer c3 = new Customer("010-8888-8888", "안정원");
			
			System.out.println(c1);
			System.out.println(c2);
			System.out.println(c3);
			
			System.out.println(c2.equals(c3));
		}
}

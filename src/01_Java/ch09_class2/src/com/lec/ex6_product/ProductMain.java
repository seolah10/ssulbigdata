package com.lec.ex6_product;


public class ProductMain {
	public static void main(String[] args) {
		
		Product p1 = new Product();
		p1.infoString();
		
		Product p2 = new Product();
		p2
		.infoString();
		
		Product p3 = new Product();
		p3.infoString();
		
			System.out.println("static ����: "+Product.count);
			System.out.println("static ����: "+p1.count);
	}
}

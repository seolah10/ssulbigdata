package com.lec.ex6_product;

// Product p1 = new Product();

public class Product {
	
		private int serialNo; // 객체 고유 번호
		public static int count = 100;
		
		public Product() { // 생성자
			serialNo = ++count;
		}
		
		public void infoString() { // 메소드
				System.out.println("serialNo= "+serialNo+"\t공유변수 count= "+count);
		}
		// S & G 
		public void setSerialNo(int serialNo) {
			this.serialNo = serialNo;
		}
		public int getSerialNo() {
			return serialNo;
		}
}

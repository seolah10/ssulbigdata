package com.lec.ex4_object;

// ���ǰ Ȯ���ϱ�

public class Goods {

		private String goodCode;
		private String goodName;
		private int price;
		private int stockNum;

		public Goods(String goodCode, String goodName, int price, int stockNum) {
			this.goodCode = goodCode;
			this.goodName = goodName;
			this.price = price;
			this.stockNum = stockNum;
		}
		@Override
		public String toString() {
			return goodName+"("+goodCode+")�� ����: "+price+", ������: "+stockNum;
		}
	
	
}

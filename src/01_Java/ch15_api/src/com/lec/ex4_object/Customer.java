package com.lec.ex4_object;

public class Customer {
	
		private String tel;
		private String name;
		private int point;
		private int amount;
		
		public Customer(String tel, String name) {
			this.tel = tel;
			this.name = name;
			point = 3000;
			//System.out.println("ȸ������ �����մϴ�. 3,000�� ����Ʈ �־��Ƚ��ϴ�.");
		}
		@Override
		public String toString() {
				String post = tel.substring(tel.lastIndexOf("-")+1);
			
				return  name + "("+post+")"+"����Ʈ: "+point+", �����ݾ�: "+amount;
		}
		@Override
		public boolean equals(Object obj) {
				if(this == obj) {
					return true;
					
				}
				if (obj!=null && obj instanceof Customer) {
					return tel.equals(((Customer)obj).tel);
				}
				return false;
		}
		

}

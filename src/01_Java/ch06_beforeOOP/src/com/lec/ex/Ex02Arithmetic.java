package com.lec.ex;

public class Ex02Arithmetic {

		public int sum(int to) {
			int result = 0; // �����ؼ� ������ ����
	
			for(int i=1 ; i<=0 ; i++) { 
					result += i; 
	}
			return result; 
}
		public int sum(int from, int to) {
			int result = 0; // �����ؼ� ������ ����
	
			for(int i=from ; i<=to ; i++) {
					result += i;
	}
			return result;
}
		public String evenOdd(int value) { 
			String result = value%2==0 ? "¦���Դϴ�" : "Ȧ���Դϴ�";
	
			return result;
	}
		public static int abs(int value) {
			int result = (value>=0 ? value : -value);
			
//			if(value>=0) {
//				result = value;
//			}else {
//				result = -value;
//			}
			return result;
		}
}

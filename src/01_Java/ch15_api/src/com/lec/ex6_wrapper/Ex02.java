package com.lec.ex6_wrapper;

// ���������Լ� 	cf. ���� == �Ű�����

public class Ex02 {
	
		public static void main(String[] args) {
			
				int total = valueSum("10","20");
				System.out.println("���� ���� ���� "+total);
		}
		private static int valueSum(String ... value) {
			
			int result = 0;
			
			for(int i=0 ; i<value.length ; i++) {
				result += Integer.parseInt(value[i]);
				//Integer.parseInt(val); val���ڿ��� ������ �ٲ۴�. 
			}
			return result;
		}

}

package com.lec.ex3_exceptionExs;

// (���� ���ڰ��� ����� ������ ���, �̷� ����ó���� �߻��ϳ�, ��� �̷����� ���Ǿ���.)

public class Ex01_nullPoint {
	
		public static void main(String[] args) {
			
				String greeting  = "Hello";
				System.out.println(greeting.toUpperCase());
				
				greeting = null;
				System.out.println(greeting.toUpperCase());
		}

}

package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int sum = 0; // ���� ����
		for(int i=1 ; i<=10 ; i++) {
			sum += i;
		}
		System.out.println("���� "+sum);
		System.out.println((sum%2==0) ? "¦���Դϴ�" : "Ȧ���Դϴ�");
		
		sum = 0; //���� ����
		for (int i=1 ; i<=50 ; i++) {
			sum += i;
		}
		System.out.println("���� "+sum);
		System.out.println((sum%2==0)? "¦���Դϴ�":"Ȧ���Դϴ�");
		
		sum = 0; //��������
		for(int i=10 ; i<=50 ; i++) {
			sum += i;
		}
		System.out.println("���� "+sum);
		System.out.println((sum%2==0)? "¦���Դϴ�":"Ȧ���Դϴ�");
	}

}

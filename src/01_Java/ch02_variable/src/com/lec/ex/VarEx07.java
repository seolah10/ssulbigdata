package com.lec.ex;

public class VarEx07 {

	public static void main(String[] args) {
		
		int i1 = 10; // 4byte
		long l1 = 2200000000L; 
		l1 = 10; 
			// 8byte�� long���� 4byte¥�� 10�� �Ҵ��ϱ� ����
			// 8byte(long��)�� �������� ����ȯ
		
		double d = i1; // �������� ����ȯ
		d = 10.7;
		i1 = (int)d; // ������� �� ��ȯ�ÿ��� ������ �ս��� �� ���� �ִ�.
			
			System.out.println("i1= "+i1);
		
	}
}

package com.lec.ex;

public class VarEx02_04 {
	
	public static void main(String[] args) {
		
		// �������� ���
		// 1. �ڷ��� ������;
		int num1; // ���� �ϰ� �� �Ҵ��� ���� ����
			num1 = 10;
				System.out.println("num1= "+num1);
			
		// 2. �ڷ��� ������ = ��; 
		char c1 = '��';
				System.out.println("c1= "+c1);
			
		// 3. �ڷ��� ������1, ������2, ...������n;
		boolean b1, b2, b3;
			b1 = true;
			b2 = false;
			b3 = true;
				System.out.println
				("b1= "+b1+"\t b2= "+b2+"\t b3= "+b3+"\n");
		
		// 4. �ڷ��� ������1 = ��1, ������2 = ��2 ..., ������n = ��n;
		long l1 = 2200000000L; 
		float f1 = 1.19f,
			  f2 = 2.22f,
			  f3;
					System.out.println
						("f1= "+f1+"\t f2= "+f2);
					System.out.printf
						("f1 = %3.1f, f2= %4.1f\n", f1,f2);
			// %f:�Ǽ�, %d:����. %c:����, %s:���ڿ�, %x:16����
					
					System.out.println("���α׷� ��");
	} // ���α׷� ��
} // class ��

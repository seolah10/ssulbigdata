package com.lec.ex02;

//�߻� Ŭ������ �� �� �̻��� �߻� �޼ҵ带 ����
//Super s = new Super(); �Ұ�
//s.method(); �Ұ�

public abstract class Super {

		public Super() {} // ����Ʈ ������
		
		public abstract void method1(); // �߻� �޼ҵ� 
		
		public void method2() { // �Ϲ� �޼ҵ�
			System.out.println("Super�� method2()");
		}
}

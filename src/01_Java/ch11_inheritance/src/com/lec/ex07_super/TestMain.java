package com.lec.ex07_super;

public class TestMain {
	
 public static void main(String[] args) {
	
	 ChildClass obj = new ChildClass();
	 
	 System.out.println(obj.getC()); // �θ�Ŭ���� ����Ʈ��, �ڽ�Ŭ���� ����Ʈ��, �ڽ�Ŭ���� �Ű�����
	 System.out.println(obj.getP()); // �θ�Ŭ���� �Ű������� ���
	 
	 obj.getPapaName();
	 obj.getMamaName();
}

}

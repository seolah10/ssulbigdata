package com.lec.ex04_abc;

public class TestMain {

	public static void main(String[] args) {
		
		S_Parent s = new S_Parent();
//		A_Child a = new A_Child();
		S_Parent a = new A_Child(); // A�� S�� �ڼ� Ŭ������ �̷��Ե� �����ϴ�. (�ݴ�δ� �Ұ���)
//		Object a = new A_Child(); // Object ���� A�� �θ�Ŭ������ �̰͵� ����
		
			System.out.println(a.s);

		S_Parent b = new B_Child();
		S_Parent c = new C_Child();
		
		S_Parent[] sArr = {new A_Child(), new B_Child(), new C_Child()}; 
	}
}

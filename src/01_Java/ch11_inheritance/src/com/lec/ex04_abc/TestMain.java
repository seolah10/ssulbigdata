package com.lec.ex04_abc;

public class TestMain {

	public static void main(String[] args) {
		
		S_Parent s = new S_Parent();
//		A_Child a = new A_Child();
		S_Parent a = new A_Child(); // A가 S의 자손 클래스라서 이렇게도 가능하다. (반대로는 불가능)
//		Object a = new A_Child(); // Object 역시 A의 부모클래스라서 이것도 가능
		
			System.out.println(a.s);

		S_Parent b = new B_Child();
		S_Parent c = new C_Child();
		
		S_Parent[] sArr = {new A_Child(), new B_Child(), new C_Child()}; 
	}
}

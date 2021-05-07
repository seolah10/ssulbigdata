package com.lec.ex07_super;

public class TestMain {
	
 public static void main(String[] args) {
	
	 ChildClass obj = new ChildClass();
	 
	 System.out.println(obj.getC()); // 부모클래스 디폴트값, 자식클래스 디폴트값, 자식클래스 매개변수
	 System.out.println(obj.getP()); // 부모클래스 매개변수만 출력
	 
	 obj.getPapaName();
	 obj.getMamaName();
}

}

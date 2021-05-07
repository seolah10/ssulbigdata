package com.lec.ex01_store;

public class TestMain {

	public static void main(String[] args) {
		
//		HeadQuarterStore st = new HeadQuarterStore("== 본점 =="); 추상 클래스는 새 객체 생성 불가
//			System.out.println(st.getName());
//		
//			st.kimchi();
//			st.budae();
//			st.bibim();
//			st.sundae();
//			st.gonggi();
			
		StoreNum1 st1 = new StoreNum1("== 주택가 1호점 ==");
			System.out.println(st1.getName());
			
			st1.kimchi();
			st1.budae();
			st1.bibim();
			st1.sundae();
			st1.gonggi();
			
		StoreNum2 st2 = new StoreNum2("== 대학가 2호점 ==");
			System.out.println(st2.getName());
			
			st2.kimchi();
			st2.budae();
			st2.bibim();
			st2.sundae();
			st2.gonggi();
		
		StoreNum3 st3 = new StoreNum3("== 증권가 3호점 ==");
			System.out.println(st3.getName());
		
			st3.kimchi();
			st3.budae();
			st3.bibim();
			st3.sundae();
			st3.gonggi();
			
//			HeadQuarterStore[] store = {st, st1, st2, st3};
	}
}












package com.lec.ex01store;

public class TestMain2 {
	
	public static void main(String[] args) {
		
		HeadQuarterStore[] store = {//new HeadQuarterStore("== 본사 =="),
									new StoreNum1("== 주택가 1호점 =="),
									new StoreNum2("== 대학가 2호점 =="),
									new StoreNum3("== 증권가 3호점 ==") };
		
		for(HeadQuarterStore s : store) {
			System.out.println(s.getName());
			
			s.kimchi();
			s.budae();
			s.bibim();
			s.sundae();
			s.gonggi();
		}
//		for (int i=0 ; i<store.length ; i++) { 
//			System.out.println(store[i].getName());
//			
//			store[i].kimchi();
//			store[i].budae();
//			store[i].bibim();
//			store[i].sundae();
//			store[i].gonggi(); "가급적이면 확장 for문 사용 추천해요!"
//		}
	}

}


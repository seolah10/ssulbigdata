package com.lec.ex01store;

public class TestMain2 {
	
	public static void main(String[] args) {
		
		HeadQuarterStore[] store = {//new HeadQuarterStore("== ���� =="),
									new StoreNum1("== ���ð� 1ȣ�� =="),
									new StoreNum2("== ���а� 2ȣ�� =="),
									new StoreNum3("== ���ǰ� 3ȣ�� ==") };
		
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
//			store[i].gonggi(); "�������̸� Ȯ�� for�� ��� ��õ�ؿ�!"
//		}
	}

}


package com.lec.ex11_store;

public class TestMain {

	public static void main(String[] args) {
		
		HeadQuarterStore st = new HeadQuarterStore("== ���� ==");
			System.out.println(st.getName());
		
			st.kimchi();
			st.budae();
			st.bibim();
			st.sundae();
			st.gonggi();
			
		StoreNum1 st1 = new StoreNum1("== ���ð� 1ȣ�� ==");
			System.out.println(st1.getName());
			
			st.kimchi();
			st.budae();
			st.bibim();
			st.sundae();
			st.gonggi();
			
		StoreNum2 st2 = new StoreNum2("== ���а� 2ȣ�� ==");
			System.out.println(st2.getName());
			
			st.kimchi();
			st.budae();
			st.bibim();
			st.sundae();
			st.gonggi();
		
		StoreNum3 st3 = new StoreNum3("== ���ǰ� 3ȣ�� ==");
			System.out.println(st3.getName());
		
			st.kimchi();
			st.budae();
			st.bibim();
			st.sundae();
			st.gonggi();
			
//			HeadQuarterStore[] store = {st, st1, st2, st3};
	}
}












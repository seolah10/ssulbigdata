package com.lec.ex4_threadN_objectN;

public class ThreadEx2TestMain {
	
		public static void main(String[] args) {
			
				// t1.run() �����ϴ� threadA ���� / t1.num
				Thread t1 = new ThreadEx2("A");
				// t1.setName("A");
				
				// t2.run() �����ϴ� threadB ���� / t2.num
				Thread t2 = new ThreadEx2("B");
				
				t1.start();
				t2.start();
		}
}

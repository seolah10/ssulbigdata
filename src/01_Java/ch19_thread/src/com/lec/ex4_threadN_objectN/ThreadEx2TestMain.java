package com.lec.ex4_threadN_objectN;

public class ThreadEx2TestMain {
	
		public static void main(String[] args) {
			
				// t1.run() 荐青窍绰 threadA 积己 / t1.num
				Thread t1 = new ThreadEx2("A");
				// t1.setName("A");
				
				// t2.run() 荐青窍绰 threadB 积己 / t2.num
				Thread t2 = new ThreadEx2("B");
				
				t1.start();
				t2.start();
		}
}

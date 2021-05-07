package com.lec.ex5_synchronize;

public class ThreadExTestMain {
	
		public static void main(String[] args) {
				
				Runnable target = new ThreadEx(); //작업객체 1개 thread 공유
				
				Thread t1 = new Thread(target, "A");
				Thread t2 = new Thread(target, "B");
				
				t1.start();
				t2.start();
		}

}

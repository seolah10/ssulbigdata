package com.lec.ex5_synchronize;

public class ThreadExTestMain {
	
		public static void main(String[] args) {
				
				Runnable target = new ThreadEx(); //�۾���ü 1�� thread ����
				
				Thread t1 = new Thread(target, "A");
				Thread t2 = new Thread(target, "B");
				
				t1.start();
				t2.start();
		}

}

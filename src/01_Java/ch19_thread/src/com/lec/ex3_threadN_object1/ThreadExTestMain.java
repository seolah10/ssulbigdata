package com.lec.ex3_threadN_object1;

public class ThreadExTestMain {
	
		public static void main(String[] args) {
			
				Runnable target = new ThreadEx(); // 작업객체1개를 두 개의 thread가 공유
				
				Thread t1 = new Thread(target, "A");
				Thread t2 = new Thread(target, "B");
				
				t1.start();
				t2.start();
				
		}

}
// t2에 증가 설정을 하지 않았어도
// t1의 증가 설정을 공유하고 있으므로 t2의 num도 계속 증가한다.
// 다음 패키지에서 공유하지 않도록 설정해보도록 한다.
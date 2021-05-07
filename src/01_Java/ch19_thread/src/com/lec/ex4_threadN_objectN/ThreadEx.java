package com.lec.ex4_threadN_objectN;

public class ThreadEx implements Runnable {
	
		private int num = 0; // 공유 변수 

		@Override
		public void run() {
				for(int i=0 ; i<10 ; i++) {
						String threadName = Thread.currentThread().getName();
						
						if(threadName.equals("A")) {
							System.out.println("~ ~ ~ A 수행중 ~ ~ ~");
							num++;
						}
						System.out.println(threadName +"의 num = "+num);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) { }
				}
			
		}
		
		

}

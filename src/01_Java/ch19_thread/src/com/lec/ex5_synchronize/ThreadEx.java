package com.lec.ex5_synchronize;

//쓰레드 N개가 작업객체1를 공유 - Runnable을 이용

public class ThreadEx implements Runnable {
	
		private int num = 0;

		// synchronize run() 수행 중에는 아무도 끼어들지 못함
		@Override
		public void run() {
				for(int i=0 ; i<10 ; i++) {
						out();
						
						try {
							Thread.sleep(500);
						
						} catch (InterruptedException e) {
						
						}
				}
	
			
		}
		private synchronized void out() {
				String threadName = Thread.currentThread().getName();
				
				if(threadName.equals("A")) { 
						System.out.println("~ ~ ~ 수행중 ~ ~ ~");
						num++;
				}
				System.out.println(threadName+"의 num= "+num);
		}
		
}

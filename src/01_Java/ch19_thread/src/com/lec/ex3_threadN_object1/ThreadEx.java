package com.lec.ex3_threadN_object1;

//������ N���� �۾���ü1�� ���� - Runnable�� �̿�

public class ThreadEx implements Runnable {
	
		private int num = 0; // ���� ����

		@Override
		public void run() {
			
			 	for(int i=0 ; i<10 ; i++) {
			 			String threadName = Thread.currentThread().getName();
			 			
			 			if(threadName.equals("A")) { 
			 					System.out.println("~ ~ ~ A ������ ~ ~ ~");
			 					num++;
			 			}
			 			System.out.println(threadName+"�� num= "+num);
			 			
			 			try {
							Thread.sleep(500);
							
						} catch (InterruptedException e) {
							
						}
			 	}
			
		}

}

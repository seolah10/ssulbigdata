package com.lec.ex5_synchronize;

//������ N���� �۾���ü1�� ���� - Runnable�� �̿�

public class ThreadEx implements Runnable {
	
		private int num = 0;

		// synchronize run() ���� �߿��� �ƹ��� ������� ����
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
						System.out.println("~ ~ ~ ������ ~ ~ ~");
						num++;
				}
				System.out.println(threadName+"�� num= "+num);
		}
		
}

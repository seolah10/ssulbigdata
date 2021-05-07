package com.lec.ex2_thread;

public class TargetExTestMain {
		
		public static void main(String[] args) {
				
				// thread ���� - target01.run()�� ����
				Thread target01 = new TargetEx01();
				target01.setName("A"); // thread �̸� setting
				
				// thread ���� - target02.run()�� ����
				Thread target02 = new TargetEx02();
				target02.setName("B");
				
				target01.start();
				target02.start();
				
				for(int i=0 ; i<10 ; i++) { 
						System.out.println("���� main�Լ�");
						
						try {
							Thread.sleep(500);
							
						} catch (InterruptedException e) {
							
						}
				}
		}

}

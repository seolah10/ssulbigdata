package com.lec.ex1_runnable;

// target 1, 2 ���� �����ϱ� (���� thread�� �Բ�)

public class TargetExTestMain {
		
		public static void main(String[] args) {
			
				Runnable target01 = new TargetEx01();
				//TargetEx01 target01 = new TargetEx01();
				Runnable target02 = new TargetEx02();
				//TargetEx02 target02 = new TargetEx02();
				
				// "A"��� �̸��� ������ ���� - target01.run()�� �����ϴ� ������
				Thread threadA = new Thread(target01, "A"); // (�̸��� �������� ������ JVM�� �˾Ƽ� �����Ѵ�.)
				// "B"��� �̸��� ������ ���� - target01.run()�� �����ϴ� ������
				Thread threadB = new Thread(target02, "B");
				
				threadA.start();
				threadB.start();
				
				for(int i=0 ; i<10 ; i++) {
						System.out.println("���� "+Thread.currentThread().getName());
						
						try {
							Thread.sleep(500);
							
						} catch (InterruptedException e) {
							
						}
				}
				
		}

}

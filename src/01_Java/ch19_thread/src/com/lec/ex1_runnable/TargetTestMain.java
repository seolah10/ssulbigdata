package com.lec.ex1_runnable;

public class TargetTestMain {
	
		public static void main(String[] args) {
				
				Target target = new Target();
//				Runnable target = new Target();
				
				// "A"��� �̸��� �����带 ���� - target.run()�� �����ϴ� ������
				Thread t1 = new Thread(target, "A");
				// "B"��� �̸��� �����带 ���� - target.run()�� �����ϴ� ������
				Thread t2 = new Thread(target, "B");
				
				t1.start();
				t2.start();
				
				System.out.println(Thread.currentThread().getName());
				System.out.println("Main�Լ� ��");
		}

}

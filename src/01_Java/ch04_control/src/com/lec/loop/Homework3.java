package com.lec.loop;

import java.util.Scanner;

// ��ǻ�Ϳ� ����(0) ����(1) ��(2) �����ϱ�
public class Homework3 {
	
	public static void main(String[] args) {
		
		int com, you;
				Scanner sc = new Scanner(System.in);
		
		while(true) { 
				System.out.println("����(0), ����(1), ��(2)! (����� -1 �Է�)");
				you = sc.nextInt();
				
			if(you==-1) { 
					break;
			}

			com = (int)(Math.random()*3);

			if(you > 2 || you < -1) {
					System.out.println("�ٽ� ����� ������");
			}
			else if((you+2)%3 == com) {
					System.out.println("����� "+(you==0 ? "����" : you==1 ? "����" : "��"));
					System.out.println("��ǻ�ʹ� "+(com==0 ? "����" : com==1 ? "����" : "��"));
					System.out.println("�̱�̾��!");
			}
			else if(you == com) {
				System.out.println("����� "+(you==0 ? "����" : you==1 ? "����" : "��"));
				System.out.println("��ǻ�ʹ� "+(com==0 ? "����" : com==1 ? "����" : "��"));
				System.out.println("���׿�~");
			}
			else {
				System.out.println("����� "+(you==0 ? "����" : you==1 ? "����" : "��"));
				System.out.println("��ǻ�ʹ� "+(com==0 ? "����" : com==1 ? "����" : "��"));
				System.out.println("���̽��ϴ�");

			} // if��
		} // while��
		sc.close();
		System.out.println("bye");
	}

}

package com.lec.loop;

import java.util.Scanner;

// ���� �̱� ������ ���� ���� �� ! 
public class Homework4 {
	
	public static void main(String[] args) {
		
		int com, you;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("����� �̱� ������ ����(0), ����(1), ��!(2)");
			you = sc.nextInt();
			com = (int)(Math.random()*3);
			
			if(you > 2  || you < -1) {
				System.out.println("�ٽ� ����� ������");
			}
			else if ((you+2)%3 == com) { 
				System.out.println("����� "+(you==0 ? "����" : you==1 ? "����" : "��"));
				System.out.println("��ǻ�ʹ� "+(com==0 ? "����" : com==1 ? "����" : "��") );
				System.out.println("�̱�̾��!");
			}
			else if (you == com) {
				System.out.println("����� "+(you==0 ? "����" : you==1 ? "����" : "��"));
				System.out.println("��ǻ�ʹ� "+(com==0 ? "����" : com==1 ? "����" : "��") );
				System.out.println("�����");
			}
			else {
				System.out.println("����� "+(you==0 ? "����" : you==1 ? "����" : "��"));
				System.out.println("��ǻ�ʹ� "+(com==0 ? "����" : com==1 ? "����" : "��") );
				System.out.println("���̳׿�, �ٽ��ұ��?");
			} // if 
		}
		while( (you<0 || you>2) || ((you+1)%3 == com || you == com) );
		
		sc.close();
		System.out.println("bye!");
	}

}

package com.lec.loop;

import java.util.Scanner;

// �ζ� ��ȣ ������ ���α׷�2 

public class Ex10_doWhile_randomNum2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			int lotto = (int)(Math.random()*45)+1; 
			int num; // ����ڿ��� �Է¹��� ���� �����ϴ� ����
			int min = 1;
			int max = 45;
			
		do {
					System.out.printf("%d���� %d������ ��ȣ �� �ϳ��� �Է��ϼ���", min, max);
					num = sc.nextInt();
				
				if(num>lotto) { 
					System.out.println(num+"���� ���� ���� �Է��ϼ���");
					max = num-1;
				}
				else if(num<lotto) { 
					System.out.println(num+"���� ū ���� �Է��ϼ���");
					min  = num+1;
				}

			}
			while(num!=lotto);
					
					System.out.println("�����մϴ�! �����Դϴ�.");
		}
	
	}


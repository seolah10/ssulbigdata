package com.lec.loop;

import java.util.Scanner;

// �ζ� ��ȣ �˾Ƹ����� ���α׷� ����

public class Ex10_doWhile_randomNum {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int lotto = (int)(Math.random()*45)+1; // ���� ����  
		int num; // ����ڿ��� �Է¹��� ���� �����ϴ� ����
		
		do {
				System.out.print("�ζ� ��ȣ �� ���� �˾Ƹ��� ������.");
				num = sc.nextInt();
				
				if(num>lotto) { 
					System.out.println(num+"���� ���� ���� �Է��ϼ���.");
				}
				else if(num<lotto) {
					System.out.println(num+"���� ū ���� �Է��ϼ���.");
				}
			
			} while (num!=lotto);
					
					System.out.println("���߼̽��ϴ�!!");
		}
	
	}








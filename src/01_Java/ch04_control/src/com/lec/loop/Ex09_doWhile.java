package com.lec.loop;

// ¦���� �Է��� ������ ��� ����� �䱸�ϴ� ���α׷� ����
import java.util.Scanner;

public class Ex09_doWhile {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num;
		
			do { 
					System.out.print("¦���� �Է��ϼ���: ");
					num = scanner.nextInt();
					// ����ڷκ��� �Է¹��� ���� num�� �Ҵ�
			}
			while (num%2 == 1 || num%2 == -1);
					System.out.println("�Է��Ͻ� ¦����"+num);
		}
		
	}



package com.lec.ex;
// ���밪 ���ϱ�
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su = -5;
			System.out.println(su+"�� ���밪��" +Ex02Arithmetic.abs(su));
		
		Ex02Arithmetic ar = new Ex02Arithmetic();
		
		int sum = ar.sum(10,51);
			System.out.println("���� "+sum);
			System.out.println(ar.evenOdd(sum));
			System.out.println("************************");
			
		sum = ar.sum(10,51);
			System.out.println("���� "+sum);
			System.out.println(ar.evenOdd(sum));
		
		
	}
}

package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03 {
	
		public static void main(String[] args) {
			
				Scanner sc = new Scanner(System.in);
				
				int i, j = 1;
				
				do { 
					
					try {
							System.out.print("ù��° ��: "); // (���� ���ڸ� �Է��� ��츦 ����Ͽ� ����ó��)
							i = sc.nextInt(); // @\n
							break;
							
					} catch (InputMismatchException e) { // ���� �Է����� ������ ��Ÿ���� �����޽��� (Exception�̶�� ��� ����)
							System.out.println(e.getMessage());
							System.out.println("���ڸ� �Է��ϼ���.");
							sc.nextLine(); // ���� ����
					}
					
				} while (true);	 // �ٽ� do�� �ö󰣴�.
				
				System.out.print("�ι�° ��: ");
				
				try { 	// ���� �߻��� catch�� �ٷ� ��������, try���� ����� �������� �ʴ´�.
						j = sc.nextInt();
						
						System.out.println("i = "+i+", j = "
								+ ""+j);
						System.out.println("i * j = "+ (i*j));
						System.out.println("i / j = "+ (i/j));
						
				} catch (InputMismatchException e) {	// j�� �ʱ�ȭ �ʿ�
					
						System.out.println(e.getMessage());
						System.out.println("�ι�° ���� �߸� �Է��ϼż� 1�� �ʱ�ȭ�˴ϴ�.");
						
				} catch (ArithmeticException e) {
						
						System.out.println(e.getMessage()+"0���� �����Ѥ� ���� �н�");
				
				} catch (Exception e) { 	// catch�� 2�� �̻� ���� ���, �׳� exception�� ������ ���� �Ʒ��� �ִ� catch�� �Է��ؾ� �Ѵ�.

						System.out.println(e.getMessage()+"���� �����ϱ�?");
						
				}
				
				System.out.println("i + j = "+ (i+j));
				System.out.println("i - j = "+ (i-j));
				
				System.out.println("Done");
				sc.close();
		}

}







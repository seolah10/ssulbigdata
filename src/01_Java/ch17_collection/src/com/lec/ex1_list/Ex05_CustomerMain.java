package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex05_CustomerMain {
	
		public static void main(String[] args) {
			
				Scanner sc = new Scanner(System.in);
				String answer, name, phone, address;
				
				ArrayList<Customer> customers = new ArrayList<Customer>();
				// Customer[] cs = new Cumstomer[10];
				
				do {
						System.out.println("ȸ������ �Ͻðڽ��ϱ�(Y/N)? ");
						answer = sc.next();
						
						if(answer.equalsIgnoreCase("y")) { // ȸ������ ����
								System.out.print("����: ");
								name = sc.next();
								
								System.out.print("����ó: ");
								phone = sc.next();
								
								System.out.print("�ּ�: ");
								sc.nextLine(); // ���� ����
								address = sc.nextLine();
								
								customers.add(new Customer(name, phone, address));
						} else if (answer.equalsIgnoreCase("n")) {
								break;
						}
				} while(true);
				System.out.println("������ ȸ�� ����Ʈ ���");
				
				for(Customer customer : customers) { 
						System.out.println(customer);
				}
//				for(int idx=0 ; idx<customers.size() ; idx++) { 
//						System.out.println(customers.get(idx));
//				}
		}

}

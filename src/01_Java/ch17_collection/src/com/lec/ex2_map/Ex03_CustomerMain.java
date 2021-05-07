package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.lec.ex1_list.Customer;

public class Ex03_CustomerMain {

		public static void main(String[] args) {
			
				Scanner sc = new Scanner(System.in);
				String answer, name, phone, address;
				
				HashMap<String, Customer> customers = new HashMap<String, Customer>();
				
				while(true) { 
						System.out.println("ȸ������ �Ͻðڽ��ϱ�(Y/N)? ");
						answer = sc.nextLine().trim();

						if(answer.equalsIgnoreCase("n")) { 
								break;
								
						}else if (answer.equalsIgnoreCase("y")) {
								System.out.print("����: ");
								name = sc.nextLine();
								
								System.out.print("����ó: ");
								phone = sc.nextLine();
								
								System.out.print("�ּ�: ");
								address = sc.nextLine();
							
								customers.put(phone, new Customer(name, phone, address));
						}
				} // while
				sc.close();
				if(customers.isEmpty()) {
						System.out.println("������ ȸ���� �����ϴ�.");

				} else {
						System.out.println("������ ȸ�� ���");
						Iterator<String> iterator = customers.keySet().iterator();
						
						while(iterator.hasNext()) { 
								String key = iterator.next();
								System.out.println(customers.get(key));
						} //while
				} //if
		}
}

























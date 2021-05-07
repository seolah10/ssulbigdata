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
						System.out.println("회원가입 하시겠습니까(Y/N)? ");
						answer = sc.next();
						
						if(answer.equalsIgnoreCase("y")) { // 회원가입 진행
								System.out.print("성명: ");
								name = sc.next();
								
								System.out.print("연락처: ");
								phone = sc.next();
								
								System.out.print("주소: ");
								sc.nextLine(); // 버퍼 삭제
								address = sc.nextLine();
								
								customers.add(new Customer(name, phone, address));
						} else if (answer.equalsIgnoreCase("n")) {
								break;
						}
				} while(true);
				System.out.println("가입한 회원 리스트 목록");
				
				for(Customer customer : customers) { 
						System.out.println(customer);
				}
//				for(int idx=0 ; idx<customers.size() ; idx++) { 
//						System.out.println(customers.get(idx));
//				}
		}

}

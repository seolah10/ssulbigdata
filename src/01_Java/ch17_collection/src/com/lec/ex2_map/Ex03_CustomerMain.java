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
						System.out.println("회원가입 하시겠습니까(Y/N)? ");
						answer = sc.nextLine().trim();

						if(answer.equalsIgnoreCase("n")) { 
								break;
								
						}else if (answer.equalsIgnoreCase("y")) {
								System.out.print("성명: ");
								name = sc.nextLine();
								
								System.out.print("연락처: ");
								phone = sc.nextLine();
								
								System.out.print("주소: ");
								address = sc.nextLine();
							
								customers.put(phone, new Customer(name, phone, address));
						}
				} // while
				sc.close();
				if(customers.isEmpty()) {
						System.out.println("가입한 회원이 업습니다.");

				} else {
						System.out.println("가입한 회원 목록");
						Iterator<String> iterator = customers.keySet().iterator();
						
						while(iterator.hasNext()) { 
								String key = iterator.next();
								System.out.println(customers.get(key));
						} //while
				} //if
		}
}

























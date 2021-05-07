package com.lec.ex10bookLib;

import java.util.Scanner;

public class LibMain {

		public static void main(String[] args) {
			
			BookLib[] books = {new BookLib("890�� - 100","java","�ƹ���"),
							   new BookLib("890�� - 101","hadoop","�蹫��"),
							   new BookLib("890�� - 102","oracle","�̹���"),
							   new BookLib("890�� - 103","python","�ڹ���"),
							   new BookLib("890�� - 104","spark","�ֹ���") };
			
			Scanner sc = new Scanner(System.in);
			int fn, idx=0; 
			String title, borrower, checkoutDate;
			
			do {
					System.out.print("1:���� | 2:�ݳ� | 3:������Ȳ| 4:����");
					fn = sc.nextInt();
					
					switch(fn) {
					
					case 1: 
						System.out.println("���� ������: ");
						title = sc.next();
						
							for(idx=0 ; idx<books.length ; idx++) { 
								if(title.equals(books[idx].getBookTitle())) {
									break;
								} // if
							} // for
							if(idx==books.length ) { 
								System.out.println("�ش� ������ ã�� �� �����ϴ�.");
							}
							else if(books[idx].getState()==ILendable.STATE_BORROWED) {
								System.out.println(title+" ������ �������Դϴ�.");
							}
							else {
								System.out.print("������ ����: ");
								borrower = sc.next();
								System.out.print("���� ��¥: ");
								checkoutDate = sc.next();
								books[idx].checkOut(borrower, checkoutDate);
							} // if 
							break;
					case 2:
						System.out.println("�ݳ� ������: ");
						title = sc.next();
						
						for(idx=0 ; idx < books.length ; idx++) {
							if(title.equals(books[idx].getBookTitle())) { 
								break;
							}
						} // for
						if(idx == books.length) { 
							System.out.println("�ش� ������ �� �������� ������ �ƴմϴ�.");
						}
						else { 
							books[idx].checkIn();
						}
						break;
				
					case 3:
						for(BookLib book : books) { 
							book.printState();
						} //for 
					} // switch
							   		
				} while(fn != 0);	
			sc.close();
			System.out.println("�ý��� ����");
		}
	
}
















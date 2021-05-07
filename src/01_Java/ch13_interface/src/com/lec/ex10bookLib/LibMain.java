package com.lec.ex10bookLib;

import java.util.Scanner;

public class LibMain {

		public static void main(String[] args) {
			
			BookLib[] books = {new BookLib("890ㄱ - 100","java","아무개"),
							   new BookLib("890ㄱ - 101","hadoop","김무개"),
							   new BookLib("890ㄱ - 102","oracle","이무개"),
							   new BookLib("890ㄱ - 103","python","박무개"),
							   new BookLib("890ㄱ - 104","spark","최무개") };
			
			Scanner sc = new Scanner(System.in);
			int fn, idx=0; 
			String title, borrower, checkoutDate;
			
			do {
					System.out.print("1:대출 | 2:반납 | 3:도서현황| 4:종료");
					fn = sc.nextInt();
					
					switch(fn) {
					
					case 1: 
						System.out.println("대출 도서명: ");
						title = sc.next();
						
							for(idx=0 ; idx<books.length ; idx++) { 
								if(title.equals(books[idx].getBookTitle())) {
									break;
								} // if
							} // for
							if(idx==books.length ) { 
								System.out.println("해당 도서를 찾을 수 없습니다.");
							}
							else if(books[idx].getState()==ILendable.STATE_BORROWED) {
								System.out.println(title+" 도서는 대출중입니다.");
							}
							else {
								System.out.print("대출자 성명: ");
								borrower = sc.next();
								System.out.print("대출 날짜: ");
								checkoutDate = sc.next();
								books[idx].checkOut(borrower, checkoutDate);
							} // if 
							break;
					case 2:
						System.out.println("반납 도서명: ");
						title = sc.next();
						
						for(idx=0 ; idx < books.length ; idx++) {
							if(title.equals(books[idx].getBookTitle())) { 
								break;
							}
						} // for
						if(idx == books.length) { 
							System.out.println("해당 도서는 본 도서관의 도서가 아닙니다.");
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
			System.out.println("시스템 종료");
		}
	
}
















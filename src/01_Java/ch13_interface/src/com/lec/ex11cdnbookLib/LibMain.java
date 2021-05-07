package com.lec.ex11cdnbookLib;

import java.util.Scanner;

public class LibMain {

		public static void main(String[] args) {
			
				BookLib[] books = { new BookLib("890-101","java","아무개"),
									new BookLib("890-102","hadoop","김무개"),
									new BookLib("890-103","oracle","이무개"),
									new BookLib("890-104","python","박무개"),
									new BookLib("890-105","spark","최무개")};
				
				CDLib[] cds = { new CDLib("c01","javaSrc","890-101"),
								new CDLib("c02", "ITtrend", null),
								new CDLib("c03","hadoop","a02") }; 
				
				Scanner sc = new Scanner(System.in);
				int fn, idx=0;
				String bTitle, cdTitle, borrower, checkoutDate;
				
				do {
					System.out.print("1:책대출 | 2:CD대출| 3:책 반납 | 4:CD반납 | 5:도서 및 CD 현황 | 6:종료");
					fn = sc.nextInt();
					
					switch(fn) {
					
					case 1: 
						System.out.println("대출 도서명:");
						bTitle = sc.next();
						
						for(idx=0 ; idx<books.length ; idx++) {
							if(bTitle.equals(books[idx].getBookTitle())) { 
								break;
							}
						} // for
						
						if(idx==books.length) {
							System.out.println("해당 도서를 찾을 수 없습니다.");
						}
						else if (books[idx].getState()==ILendable.STATE_BORROWED){ 
							System.out.println(bTitle+" 도서는 대출중입니다");
						}
						else {
							System.out.println("대출자 이름: ");
							borrower = sc.next();
							System.out.println("대출 날짜: ");
							checkoutDate = sc.next();
							books[idx].checkOut(borrower, checkoutDate);
						}
						// 대출 처리한 도서에 딸린 CD가 있으면 알림 메시지 출력
						int cdIdx;
						
						for(cdIdx=0 ; cdIdx<cds.length ; cdIdx++) { 
								if(books[idx].getBookNo().equals(cds[cdIdx].getBookNo())) {
									break;
								}
						}//for
						if(cdIdx!=cds.length) {
								System.out.println("대출 도서에 첨부 CD가 있습니다.");
						}
						
						break;
					
					case 2: 
						System.out.println("대출 CD명:");
						cdTitle = sc.next();
						
						for(idx=0 ; idx<cds.length ; idx++) {
							if(cdTitle.equals(cds[idx].getCdTitle())) { 
								break;
							}
						} // for
						
						if(idx==cds.length) {
							System.out.println("해당 CD를 찾을 수 없습니다.");
						}
						else if (cds[idx].getState()==ILendable.STATE_BORROWED){ 
							System.out.println(cdTitle+" CD는 대출중입니다");
						}
						else {
							System.out.println("대출자 이름: ");
							borrower = sc.next();
							System.out.println("대출 날짜: ");
							checkoutDate = sc.next();
							cds[idx].checkOut(borrower, checkoutDate);
						}
						break;
						
					case 3:
						System.out.print("반납 도서명: ");
						bTitle = sc.next();
						
						for(idx=0 ; idx<books.length ; idx++) {
							if(bTitle.equals(books[idx].getBookTitle())); {
								break;
							}
						} // for
						if(idx==books.length) {
							System.out.println("해당 도서는 본 도서관의 책이 아닙니다.");
						}
						else {
							books[idx].checkIn();
						}
						break;
						
					case 4: 
						System.out.print("반납 CD명: ");
						cdTitle = sc.next();
						
						for(idx=0 ; idx<books.length ; idx++) {
							if(cdTitle.equals(cds[idx].getCdTitle())); {
								break;
							}
						} // for
						if(idx==cds.length) {
							System.out.println("해당 CD는 본 도서관의 책이 아닙니다.");
						}
						else {
							cds[idx].checkIn();
						}
						break;
						
					case 5: 
						for(BookLib book : books) { 
							book.printState();
						}
						for(CDLib cd : cds) { 
							cd.printState();
						}
					} // switch 
				} while (fn != 0); 
				sc.close();
				System.out.println("시스템 종료");
		}
}




















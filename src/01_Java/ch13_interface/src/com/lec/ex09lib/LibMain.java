package com.lec.ex09lib;

import java.util.Scanner;

public class LibMain {
	
	public static void main(String[] args) {
		
		Book[] books = { new Book("890ㄱ - 100","java","아무개"),
						 new Book("890ㄱ - 101","hadoop","김무개"),
						 new Book("890ㄱ - 102","oracle","이무개"),
						 new Book("890ㄱ - 103","python","박무개"),
						 new Book("890ㄱ - 104","spark","최무개") };
		
		Scanner sc= new Scanner(System.in);
		int functionNum, idx=0; // 책 인덱스의 기능번호(1:대출, 2:반납...)
		String bTitle, borrower, checkOutDate;
		
		do { 
			System.out.println("1:대출 | 2:반납 | 3:도서현황 | 4:종료");
			functionNum = sc.nextInt();
			
			switch(functionNum) { 
			
			case 1: // 도서명 -> 도서 조회 -> 해당 책의 상태 -> 대출인, 대출일 -> 대출 
					
					// 1. 도서명 입력
					System.out.println("도서명을 입력하세요: ");
					bTitle = sc.next(); // 타입이 int가 아니라서 nextInt가 아니다.
				
					// 2. 도서 조회
					for(idx=0 ; idx < books.length ; idx++) {
						if(bTitle.equals(books[idx].getBookTitle())); {
							break;
						} // if
					} // for
					// 3. 책 상태 확인 후, 가능하면 대출 처리
					if (idx == books.length) { // 1) 대출 불가능 (도서 없음)
						System.out.println("해당 도서를 찾을 수 없습니다.");
					}
					else if(books[idx].getState()==ILendable.STATE_BORROWED) { // 2) 대출 불가능 (대출중)
						System.out.println(bTitle+" 도서는 대출중입니다.");
					}
					else { // 3) 대출 가능
						System.out.println("대출자 명: ");
						borrower = sc.next();
						System.out.println("대출 날짜: ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
					break;
				
			case 2: // 도서명 -> 도서 조회 -> 반납	
				System.out.println("반납할 도서명:");
				bTitle = sc.next();
				
				for(idx=0 ; idx < books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					} //if
				} // for
				
				if(idx==books.length) { 
					System.out.println("해당 도서를 찾을 수 없습니다.");
				}
				else {
					books[idx].checkIn();
				}
				break;
			
			case 3: // for문을 이용하여 도서 상태 출력
				
				for(Book book : books) { 
					book.printState();
				}
			}

		}while (functionNum != 0);
		sc.close();
		System.out.println("시스템 종료");
	}
}






















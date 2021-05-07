package com.lec.ex5_bookLib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {

		private String bookNo;
		private String bookTitle;
		private String writer;
		private String borrower; 
		private Date checkOutDate;
		private byte state; 
		
		public BookLib() { }

		public BookLib(String bookNo, String bookTitle, String writer) {
			this.bookNo = bookNo;
			this.bookTitle = bookTitle;
			this.writer = writer;
			state = STATE_NORMAL;
		}

		@Override
		public void checkOut(String borrower) throws Exception {
			
			if(state!=STATE_NORMAL) {
					throw new Exception(bookTitle+"은 대출중이에요.");
			}
			this.borrower = borrower;
			checkOutDate = new Date();
			System.out.println("\""+bookTitle+"\"이(가) 대출되었습니다.");
			System.out.println("[대출인] "+borrower);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
			System.out.println("[대출일]"+sdf.format(checkOutDate));
			
		}

		@Override
		public void checkIn() throws Exception {
			
			if(state!=STATE_BORROWED) {
					throw new Exception(bookTitle+"은 대출중이 아니었는데 반납한다고 합니다.");
			}
			Date now = new Date();
			long diff = now.getTime() - checkOutDate.getTime();
			long day = diff / (24*60*60*1000); 
			
			if(day > 14) {
				System.out.println("연체료 일일 100원 부과합니다.");
				day = day - 14; 
				System.out.println("내셔야 할 연체료는 " + (day*100) + "원");
				
				Scanner sc = new Scanner(System.in);
				System.out.print("연체료를 내셨나요(Y/N)? ");
				if(!sc.next().equalsIgnoreCase("y")) {
					System.out.println("연체료를 내셔야 반납 처리가 됩니다.");
					return;
				} // if 
		}
		this.borrower =null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\"" + bookTitle + "이(가) 반납되었습니다.");
	}
	
		@Override
		public String toString() {
			String temp = "\"" + bookTitle + "(" + bookNo + ") " + writer + " 著";
				
			if(state == STATE_NORMAL) {
					temp += "대출가능";
			
			} else if(state == STATE_BORROWED) {
					SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd E요일");
					temp += "대출(" + sdf.format(checkOutDate) +") 중";
					
			} else {
					temp += "행방불명";
					
			}
			return temp;
		}

		public String getBookTitle() {
			return bookTitle;
		}	
		public byte getState() {
			return state;
		}
		public void setCheckOutDate(Date checkOutDate) {
			this.checkOutDate = checkOutDate;
		}
}














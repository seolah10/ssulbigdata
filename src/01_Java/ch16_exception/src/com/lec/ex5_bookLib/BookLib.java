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
					throw new Exception(bookTitle+"�� �������̿���.");
			}
			this.borrower = borrower;
			checkOutDate = new Date();
			System.out.println("\""+bookTitle+"\"��(��) ����Ǿ����ϴ�.");
			System.out.println("[������] "+borrower);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
			System.out.println("[������]"+sdf.format(checkOutDate));
			
		}

		@Override
		public void checkIn() throws Exception {
			
			if(state!=STATE_BORROWED) {
					throw new Exception(bookTitle+"�� �������� �ƴϾ��µ� �ݳ��Ѵٰ� �մϴ�.");
			}
			Date now = new Date();
			long diff = now.getTime() - checkOutDate.getTime();
			long day = diff / (24*60*60*1000); 
			
			if(day > 14) {
				System.out.println("��ü�� ���� 100�� �ΰ��մϴ�.");
				day = day - 14; 
				System.out.println("���ž� �� ��ü��� " + (day*100) + "��");
				
				Scanner sc = new Scanner(System.in);
				System.out.print("��ü�Ḧ ���̳���(Y/N)? ");
				if(!sc.next().equalsIgnoreCase("y")) {
					System.out.println("��ü�Ḧ ���ž� �ݳ� ó���� �˴ϴ�.");
					return;
				} // if 
		}
		this.borrower =null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\"" + bookTitle + "��(��) �ݳ��Ǿ����ϴ�.");
	}
	
		@Override
		public String toString() {
			String temp = "\"" + bookTitle + "(" + bookNo + ") " + writer + " ��";
				
			if(state == STATE_NORMAL) {
					temp += "���Ⱑ��";
			
			} else if(state == STATE_BORROWED) {
					SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd E����");
					temp += "����(" + sdf.format(checkOutDate) +") ��";
					
			} else {
					temp += "���Ҹ�";
					
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














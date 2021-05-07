package com.lec.ex11cdnbookLib;

import java.util.Scanner;

public class LibMain {

		public static void main(String[] args) {
			
				BookLib[] books = { new BookLib("890-101","java","�ƹ���"),
									new BookLib("890-102","hadoop","�蹫��"),
									new BookLib("890-103","oracle","�̹���"),
									new BookLib("890-104","python","�ڹ���"),
									new BookLib("890-105","spark","�ֹ���")};
				
				CDLib[] cds = { new CDLib("c01","javaSrc","890-101"),
								new CDLib("c02", "ITtrend", null),
								new CDLib("c03","hadoop","a02") }; 
				
				Scanner sc = new Scanner(System.in);
				int fn, idx=0;
				String bTitle, cdTitle, borrower, checkoutDate;
				
				do {
					System.out.print("1:å���� | 2:CD����| 3:å �ݳ� | 4:CD�ݳ� | 5:���� �� CD ��Ȳ | 6:����");
					fn = sc.nextInt();
					
					switch(fn) {
					
					case 1: 
						System.out.println("���� ������:");
						bTitle = sc.next();
						
						for(idx=0 ; idx<books.length ; idx++) {
							if(bTitle.equals(books[idx].getBookTitle())) { 
								break;
							}
						} // for
						
						if(idx==books.length) {
							System.out.println("�ش� ������ ã�� �� �����ϴ�.");
						}
						else if (books[idx].getState()==ILendable.STATE_BORROWED){ 
							System.out.println(bTitle+" ������ �������Դϴ�");
						}
						else {
							System.out.println("������ �̸�: ");
							borrower = sc.next();
							System.out.println("���� ��¥: ");
							checkoutDate = sc.next();
							books[idx].checkOut(borrower, checkoutDate);
						}
						// ���� ó���� ������ ���� CD�� ������ �˸� �޽��� ���
						int cdIdx;
						
						for(cdIdx=0 ; cdIdx<cds.length ; cdIdx++) { 
								if(books[idx].getBookNo().equals(cds[cdIdx].getBookNo())) {
									break;
								}
						}//for
						if(cdIdx!=cds.length) {
								System.out.println("���� ������ ÷�� CD�� �ֽ��ϴ�.");
						}
						
						break;
					
					case 2: 
						System.out.println("���� CD��:");
						cdTitle = sc.next();
						
						for(idx=0 ; idx<cds.length ; idx++) {
							if(cdTitle.equals(cds[idx].getCdTitle())) { 
								break;
							}
						} // for
						
						if(idx==cds.length) {
							System.out.println("�ش� CD�� ã�� �� �����ϴ�.");
						}
						else if (cds[idx].getState()==ILendable.STATE_BORROWED){ 
							System.out.println(cdTitle+" CD�� �������Դϴ�");
						}
						else {
							System.out.println("������ �̸�: ");
							borrower = sc.next();
							System.out.println("���� ��¥: ");
							checkoutDate = sc.next();
							cds[idx].checkOut(borrower, checkoutDate);
						}
						break;
						
					case 3:
						System.out.print("�ݳ� ������: ");
						bTitle = sc.next();
						
						for(idx=0 ; idx<books.length ; idx++) {
							if(bTitle.equals(books[idx].getBookTitle())); {
								break;
							}
						} // for
						if(idx==books.length) {
							System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�.");
						}
						else {
							books[idx].checkIn();
						}
						break;
						
					case 4: 
						System.out.print("�ݳ� CD��: ");
						cdTitle = sc.next();
						
						for(idx=0 ; idx<books.length ; idx++) {
							if(cdTitle.equals(cds[idx].getCdTitle())); {
								break;
							}
						} // for
						if(idx==cds.length) {
							System.out.println("�ش� CD�� �� �������� å�� �ƴմϴ�.");
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
				System.out.println("�ý��� ����");
		}
}




















package com.lec.ex09lib;

import java.util.Scanner;

public class LibMain {
	
	public static void main(String[] args) {
		
		Book[] books = { new Book("890�� - 100","java","�ƹ���"),
						 new Book("890�� - 101","hadoop","�蹫��"),
						 new Book("890�� - 102","oracle","�̹���"),
						 new Book("890�� - 103","python","�ڹ���"),
						 new Book("890�� - 104","spark","�ֹ���") };
		
		Scanner sc= new Scanner(System.in);
		int functionNum, idx=0; // å �ε����� ��ɹ�ȣ(1:����, 2:�ݳ�...)
		String bTitle, borrower, checkOutDate;
		
		do { 
			System.out.println("1:���� | 2:�ݳ� | 3:������Ȳ | 4:����");
			functionNum = sc.nextInt();
			
			switch(functionNum) { 
			
			case 1: // ������ -> ���� ��ȸ -> �ش� å�� ���� -> ������, ������ -> ���� 
					
					// 1. ������ �Է�
					System.out.println("�������� �Է��ϼ���: ");
					bTitle = sc.next(); // Ÿ���� int�� �ƴ϶� nextInt�� �ƴϴ�.
				
					// 2. ���� ��ȸ
					for(idx=0 ; idx < books.length ; idx++) {
						if(bTitle.equals(books[idx].getBookTitle())); {
							break;
						} // if
					} // for
					// 3. å ���� Ȯ�� ��, �����ϸ� ���� ó��
					if (idx == books.length) { // 1) ���� �Ұ��� (���� ����)
						System.out.println("�ش� ������ ã�� �� �����ϴ�.");
					}
					else if(books[idx].getState()==ILendable.STATE_BORROWED) { // 2) ���� �Ұ��� (������)
						System.out.println(bTitle+" ������ �������Դϴ�.");
					}
					else { // 3) ���� ����
						System.out.println("������ ��: ");
						borrower = sc.next();
						System.out.println("���� ��¥: ");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
					break;
				
			case 2: // ������ -> ���� ��ȸ -> �ݳ�	
				System.out.println("�ݳ��� ������:");
				bTitle = sc.next();
				
				for(idx=0 ; idx < books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					} //if
				} // for
				
				if(idx==books.length) { 
					System.out.println("�ش� ������ ã�� �� �����ϴ�.");
				}
				else {
					books[idx].checkIn();
				}
				break;
			
			case 3: // for���� �̿��Ͽ� ���� ���� ���
				
				for(Book book : books) { 
					book.printState();
				}
			}

		}while (functionNum != 0);
		sc.close();
		System.out.println("�ý��� ����");
	}
}






















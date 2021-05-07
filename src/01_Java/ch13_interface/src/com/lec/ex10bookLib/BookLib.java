package com.lec.ex10bookLib;

public class BookLib extends BookInfo implements ILendable {

		private String borrower;
		private String checkoutDate;
		private byte state;
	
		public BookLib() {}

		public BookLib(String bookNo, String bookTitle, String writer) {
			super(bookNo, bookTitle, writer);
			borrower = null; 
			checkoutDate = null;
			state = STATE_NORMAL;
		}

		@Override // ����
		public void checkOut(String borrower, String checOutDate) {
			if(state != STATE_NORMAL) {
				System.out.println("���� ���� �����Դϴ�.");
				return;
			} //if 
		
			// ����ó�� ����
			this.borrower = borrower;
			this.checkoutDate = checkoutDate;
			state = STATE_BORROWED;
			
			System.out.println("\""+getBookTitle()+"\"������ ����Ǿ����ϴ�.");
					}

		@Override  // �ݳ�
		public void checkIn() {
			if(state != STATE_BORROWED) {
				System.out.println("���� ���� ������ �ƴմϴ�. ��� �Ȱ���?");
				return;
			} // if 
			
			// �ݳ�ó�� ����
			borrower = null;
			checkoutDate = null;
			state = STATE_NORMAL;
			
			System.out.println("\""+getBookTitle()+"\"������ �ݳ��Ǿ����ϴ�.");
		}

		@Override // ���� ����
		public void printState() {
			if(state == STATE_NORMAL) {
				System.out.printf("%s, %s �� - ���� ����\n",
									getBookTitle(),getWriter());
			}else if (state == STATE_BORROWED) {
				System.out.printf("%s, %s �� - ������\n",
									getBookTitle(),getWriter());
				
			}else {
				System.out.printf("%s, %s �� - ���Ҹ��Դϴ�.\n",
									getBookTitle(),getWriter());
			}
//			String msg = getBookTitle()+", "+getWriter()+" - ";
//			msg += state==STATE_NORMAL ? "���Ⱑ��" : "������";
//			System.out.println(msg); // �� ����� �ξ� �����غ��̴µ� �� �𸣰ڳ� ����.. 
	
	}

		public String getBorrower() {
			return borrower;
		}

		public String getCheckoutDate() {
			return checkoutDate;
		}

		public byte getState() {
			return state;
		}
		
	
	

}













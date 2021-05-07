package com.lec.ex11cdnbookLib;

public class CDLib extends CDInfo implements ILendable {
	
		private String borrower;
		private String checkoutDate;
		private byte state;
		
		public CDLib(String cdNo, String cdTitle, String bookNo) {
			super(cdNo, cdTitle, bookNo);
			borrower = null;
			checkoutDate = null;
			state = STATE_NORMAL;
		}
		
		@Override
		public void checkOut(String borrower, String checkoutDate) {
			if (state != STATE_NORMAL) {
				System.out.println("���� ���� CD�Դϴ�.");
				return;
			}
			this.borrower = borrower;
			this.checkoutDate = checkoutDate;
			state = STATE_BORROWED;

			System.out.println("\""+getCdTitle()+"\"CD�� ����Ǿ����ϴ�.");
		}
		
		@Override
		public void checkIn() {
			if(state != STATE_BORROWED) {
				System.out.println("���� ���� CD�� �ƴմϴ�. �̻��մϴ�.");
				return;
			}
			borrower = null;
			checkoutDate = null;
			state = STATE_NORMAL;
			
			System.out.println("\""+getCdTitle()+"\"CD�� �ݳ��Ǿ����ϴ�.");
		}
		
		@Override
		public void printState() {
			System.out.printf("%s�� CD: %s", getCdNo(), getCdTitle());
			System.out.printf("(%s) - ", (getBookNo()!=null ? getBookNo()+" ���� ÷��CD": "" ));
			System.out.printf("%s\n", state==STATE_NORMAL ? "���Ⱑ��" : "������");
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




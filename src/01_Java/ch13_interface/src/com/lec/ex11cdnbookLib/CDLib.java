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
				System.out.println("대출 중인 CD입니다.");
				return;
			}
			this.borrower = borrower;
			this.checkoutDate = checkoutDate;
			state = STATE_BORROWED;

			System.out.println("\""+getCdTitle()+"\"CD가 대출되었습니다.");
		}
		
		@Override
		public void checkIn() {
			if(state != STATE_BORROWED) {
				System.out.println("대출 중인 CD가 아닙니다. 이상합니다.");
				return;
			}
			borrower = null;
			checkoutDate = null;
			state = STATE_NORMAL;
			
			System.out.println("\""+getCdTitle()+"\"CD가 반납되었습니다.");
		}
		
		@Override
		public void printState() {
			System.out.printf("%s번 CD: %s", getCdNo(), getCdTitle());
			System.out.printf("(%s) - ", (getBookNo()!=null ? getBookNo()+" 도서 첨부CD": "" ));
			System.out.printf("%s\n", state==STATE_NORMAL ? "대출가능" : "대출중");
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




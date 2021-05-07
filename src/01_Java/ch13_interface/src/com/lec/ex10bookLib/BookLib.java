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

		@Override // 대출
		public void checkOut(String borrower, String checOutDate) {
			if(state != STATE_NORMAL) {
				System.out.println("대출 중인 도서입니다.");
				return;
			} //if 
		
			// 대출처리 로직
			this.borrower = borrower;
			this.checkoutDate = checkoutDate;
			state = STATE_BORROWED;
			
			System.out.println("\""+getBookTitle()+"\"도서가 대출되었습니다.");
					}

		@Override  // 반납
		public void checkIn() {
			if(state != STATE_BORROWED) {
				System.out.println("대출 중인 도서가 아닙니다. 어떻게 된거죠?");
				return;
			} // if 
			
			// 반납처리 로직
			borrower = null;
			checkoutDate = null;
			state = STATE_NORMAL;
			
			System.out.println("\""+getBookTitle()+"\"도서가 반납되었습니다.");
		}

		@Override // 도서 상태
		public void printState() {
			if(state == STATE_NORMAL) {
				System.out.printf("%s, %s 저 - 대출 가능\n",
									getBookTitle(),getWriter());
			}else if (state == STATE_BORROWED) {
				System.out.printf("%s, %s 저 - 대출중\n",
									getBookTitle(),getWriter());
				
			}else {
				System.out.printf("%s, %s 저 - 행방불명입니다.\n",
									getBookTitle(),getWriter());
			}
//			String msg = getBookTitle()+", "+getWriter()+" - ";
//			msg += state==STATE_NORMAL ? "대출가능" : "대출중";
//			System.out.println(msg); // 이 방법이 훨씬 간단해보이는데 잘 모르겠네 아직.. 
	
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













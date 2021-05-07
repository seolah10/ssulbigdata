package com.lec.ex11cdnbookLib;

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

	@Override
	public void checkOut(String borrower, String checkoutDate) {
		if(state!=STATE_NORMAL) {
			System.out.println("대출중인 도서입니다. ");
			return;
		}
		// 대출처리 로직
		this.borrower = borrower;
		this.checkoutDate = checkoutDate;
		state = STATE_BORROWED;
		
		System.out.println("\""+getBookTitle()+"\"도서가 대출되었습니다.");
	}

	@Override
	public void checkIn() {
		if(state!=STATE_BORROWED) {
			System.out.println("대출 중인  도서가 아니네요. 이상하군요.");
			return;
		}
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
		
		System.out.println("\""+getBookTitle()+"\"도서가 반납되었습니다.");
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) { 
			System.out.printf("%s, %s 저 - 대출가능 \n",
								getBookTitle(),getWriter());
		}
		else if (state == STATE_BORROWED) {
			System.out.printf("%s, %s 저 - 대출중 \n",
					getBookTitle(),getWriter());
		}
		else {
			System.out.printf("%s, %s 저 - 행방불명입니다. \n",
					getBookTitle(),getWriter());
			
//			String msg = getBookTitle()+", "+getWriter()+" - ";
//			msg += state == STATE_NORMAL ? "대출가능" : "대출중";
//			System.out.println(msg);
		}
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


















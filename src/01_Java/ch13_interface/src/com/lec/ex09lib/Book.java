package com.lec.ex09lib;

public class Book implements ILendable {

	private String bookNo; // 책 청구번호
 	private String bookTitle; 
	private String writer;
	private String borrower; // 대출인(입력)
	private String checkOutDate; //대출일(입력)
	private byte state; //
	
	public Book() {}
	
	
	
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
//		borrower = null;
//		checkOutDate = null; 있으나 없으나 무방
		state = STATE_NORMAL;
	}

	// Book b = new Book("890ㄱ-102나","자바","홍길동")
	// b.checkOut("신길동","201209");
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state != STATE_NORMAL) {
			System.out.println("대출 중인 도서입니다.");
			return;
		}
		// 대출 처리 로직
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; 
		System.out.println("\""+bookTitle+"\"도서가 대출되었습니다.");
	}
	//b.checkIn()
	@Override
	public void checkIn() {
		if(state != STATE_BORROWED) {
			System.out.println("대출 중인 도서가 아닙니다.");
			return;
		}
		// 반납 처리 로직
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle+"\"도서가 반납되었습니다.");
		
	}
	// b.printState() -> 자바, 홍길동저 - 대출가능(대출중)
	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.printf("%s, %s 저 - 대출가능\n",
								bookTitle, writer);
		}
		else if (state == STATE_BORROWED) {
			System.out.printf("%s, %s 저 - 대출중\n",
								bookTitle, writer);
		}
		else 
			System.out.printf("%s, %s - 유령상태입니다.\n",
					bookTitle, writer);
	
		
	}


	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}
	
	public String getBorrower() {
		return borrower;
	}
	
	public String getCheckOutDate() {
		return checkOutDate;
	}
	
	public byte getState() {
		return state;
	}






}

package com.lec.ex09lib;

public class Book implements ILendable {

	private String bookNo; // å û����ȣ
 	private String bookTitle; 
	private String writer;
	private String borrower; // ������(�Է�)
	private String checkOutDate; //������(�Է�)
	private byte state; //
	
	public Book() {}
	
	
	
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
//		borrower = null;
//		checkOutDate = null; ������ ������ ����
		state = STATE_NORMAL;
	}

	// Book b = new Book("890��-102��","�ڹ�","ȫ�浿")
	// b.checkOut("�ű浿","201209");
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state != STATE_NORMAL) {
			System.out.println("���� ���� �����Դϴ�.");
			return;
		}
		// ���� ó�� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; 
		System.out.println("\""+bookTitle+"\"������ ����Ǿ����ϴ�.");
	}
	//b.checkIn()
	@Override
	public void checkIn() {
		if(state != STATE_BORROWED) {
			System.out.println("���� ���� ������ �ƴմϴ�.");
			return;
		}
		// �ݳ� ó�� ����
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle+"\"������ �ݳ��Ǿ����ϴ�.");
		
	}
	// b.printState() -> �ڹ�, ȫ�浿�� - ���Ⱑ��(������)
	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.printf("%s, %s �� - ���Ⱑ��\n",
								bookTitle, writer);
		}
		else if (state == STATE_BORROWED) {
			System.out.printf("%s, %s �� - ������\n",
								bookTitle, writer);
		}
		else 
			System.out.printf("%s, %s - ���ɻ����Դϴ�.\n",
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

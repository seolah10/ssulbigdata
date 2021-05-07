package com.lec.ex11cdnbookLib;

public class CDInfo {

	private String cdNo;
	private String cdTitle;
	private String bookNo;
	
	public CDInfo(String cdNo, String cdTitle, String bookNo) {
		this.cdNo = cdNo;
		this.cdTitle = cdTitle;
		this.bookNo = bookNo;
	}

	public String getCdNo() {
		return cdNo;
	}

	public String getCdTitle() {
		return cdTitle;
	}

	public String getBookNo() {
		return bookNo;
	}
	
	
}

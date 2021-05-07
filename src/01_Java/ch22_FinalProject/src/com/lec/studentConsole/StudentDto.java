package com.lec.studentConsole;

public class StudentDto {
	private int rank;
	private String sno;
	private String sname; 
	private String mname; 
	private int score;
	
	public StudentDto(int rank, String sno, String sname, String mname, int score) {
		this.rank = rank;
		this.sno = sno; 
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	@Override
	public String toString() {
		return rank + "µî\t" + sname + "(" + sno + ")\t" + mname + "\t" +score;
	}
	
}

package com.lec.StudentGUI;

public class StudentSwingDto {
	private int rank;
	private String sno;
	private String sname;
	private String mname;
	private int score;
	
	public StudentSwingDto() {}
	public StudentSwingDto(String sno, String sname, String mname, int score) {
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	public StudentSwingDto(int rank, String sname, String mname, int score) {
		this.rank = rank;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}	
	@Override
	public String toString() {
		if(rank!=0) {
			return rank + "µî\t" + sname + "\t" + mname + "\t" + score;
		} else {
			return sno + "\t" + sname + "\t" + mname + "\t" + score;
		}
	}
	public int getRank() {
		return rank;
	}
	public String getSno() {
		return sno;
	}
	public String getSname() {
		return sname;
	}
	public String getMname() {
		return mname;
	}
	public int getScore() {
		return score;
	}
	
}

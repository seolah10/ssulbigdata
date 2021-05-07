package com.lec.ex7_static_student;

//성적표 만들기  <제출용 과제>


public class StudentTest {
	
	private int no; // <데이터>
		private static int count = 0;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	
	public StudentTest(String name, int kor, int eng, int mat) { // <생성자>
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor+eng+mat;
		avg = tot/3.0; 
	}
	
	public void print() { // <메소드>
		System.out.println(no+"\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+
							  "\t"+tot+"\t"+avg);
	}
	public String infoString() {
		return no+"\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+
				  "\t"+tot+"\t"+avg;
	}
	// getter & setter

	public void setNo(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getKor() {
		return kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getEng() {
		return eng;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getMat() {
		return mat;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getTot() {
		return tot;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public double getAvg() {
		return avg;
	}
}




















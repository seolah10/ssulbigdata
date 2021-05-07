package com.lec.ex1_student;
// �л����� ���� ������ ����, ����� �Է��ϴ� ǥ ����� 
public class Student {
	
	private String name; // ������ 
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	
	public Student(String name, int kor, int eng, int mat) { // ������
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor+eng+mat;
		avg = tot/3.0; 
	}
	// s.print() -> ���켺 90 90 90 270 90.0
	public void print() { 
		System.out.printf("\t %s \t %d \t %d \t %d \t %d \t %.1f\n",
						name,	kor,	eng,	mat,	tot,	avg);
	}
	//	System.out.println(s.infoString());
	public String infoString() {
		String result = String.format("\t %s \t %d \t %d \t %d \t %d \t %.1f\n",
									name,	kor,	eng,	mat,	tot,	avg);
		return result; 
	}
	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
}

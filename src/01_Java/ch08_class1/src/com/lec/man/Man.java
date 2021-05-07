package com.lec.man;
// Man kim = new Man(20, 170, 60, "010-9999-9999");
// Man yi = new Man(20, 170, 60)
// Man park = new Man(20, "010-9999-9999") 
// Man choi = new Man (170, "010-9999-9999") - 이건 실행되지 않는다. 
public class Man{
	private int age; //데이터
	private int height;
	private int weight;
	private String tel; //// (전화번호를 숫자형으로 저장하면 전화번호 앞의 0이 사라진다.)
	
	public Man() {} // 디폴트 생성자
	
	public Man(int age, int height, int weight, String tel) { // 생성자 for 'Man kim'
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.tel = tel;
	}
	public Man(int age, int height, int weight) { // 생성자 for 'Man yi'
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	public Man(int age, String tel) { // 생성자 for 'Man park'
		this.age = age;
		this.tel = tel;
		
	}
	// BMI지수를 반환하는 메소드
	public double calculationBMI() { 
		double result = weight / ((height*0.01)*(height*0.01));
		return result;
	}
	// setter & getter 
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getWeight() {
		return weight;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel() {
		return tel;
	}
}



















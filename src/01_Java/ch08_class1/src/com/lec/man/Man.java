package com.lec.man;
// Man kim = new Man(20, 170, 60, "010-9999-9999");
// Man yi = new Man(20, 170, 60)
// Man park = new Man(20, "010-9999-9999") 
// Man choi = new Man (170, "010-9999-9999") - �̰� ������� �ʴ´�. 
public class Man{
	private int age; //������
	private int height;
	private int weight;
	private String tel; //// (��ȭ��ȣ�� ���������� �����ϸ� ��ȭ��ȣ ���� 0�� �������.)
	
	public Man() {} // ����Ʈ ������
	
	public Man(int age, int height, int weight, String tel) { // ������ for 'Man kim'
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.tel = tel;
	}
	public Man(int age, int height, int weight) { // ������ for 'Man yi'
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	public Man(int age, String tel) { // ������ for 'Man park'
		this.age = age;
		this.tel = tel;
		
	}
	// BMI������ ��ȯ�ϴ� �޼ҵ�
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



















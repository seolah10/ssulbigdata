package com.lec.ex0_janmuri;
// Ŭ������ ���� �Լ��� �� Ŭ������ ���� ���(�̷� �ܸӸ��� ������ �ʾƿ�)
public class PersonInfo {
	
	private String name; // ������
	private int age; 
	private char gender; 
	
	public PersonInfo() {} // ����Ʈ �����ڴ� "�����ڰ� ���� ��츸" JVM�� ������
		
	public PersonInfo (String name, int age, char gender) { // ������ �����ε�
 		this.name = name;
		this.age  = age;
		this.gender = gender;
		}
	
	public void print() { // �޼ҵ�
		System.out.println("�̸�= "+name+"\t����= "+age+"\t����= "+gender);
		}
	public String infoString() {
		String result = "�̸�= "+name+"\t����= "+age+"\t����= "+gender;
			return result;
		}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		
		this.gender = gender;
	}
}

/// ���� �Լ� ����

//public class PersonInfo {
//	public static void main(String[] args) {
//		
//		int[] iArr = {10,20,30};
//		
//		PersonInfo[] person = {new PersonInfo("ȫ�浿" ,20,'��'),
//							   new PersonInfo("ȫ���" ,22,'��'),
//							   new PersonInfo()}; // �迭
//		
//		person[2].setName("ȫ���");
//		person[2].setAge(21);
//		person[2].setGender('��');
//		
//		for(PersonInfo p : person) { 
//					
//			p.print();
//			System.out.println(p.infoString());
//		}
////		for(int i=0 ; i<person.length ; i++) { 
////			System.out.println(person[i].infoString());
////			person[i].print();
////		}
//	}
//}




























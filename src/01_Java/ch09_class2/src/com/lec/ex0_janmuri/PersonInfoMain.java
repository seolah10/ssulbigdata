package com.lec.ex0_janmuri;

public class PersonInfoMain {
	public static void main(String[] args) {
		
		int[] iArr = {10,20,30};
		
		PersonInfo[] person = {new PersonInfo("ȫ�浿" ,20,'��'),
							   new PersonInfo("ȫ���" ,22,'��'),
							   new PersonInfo()}; // �迭
		
		person[2].setName("ȫ���");
		person[2].setAge(21);
		person[2].setGender('��');
		
		for(PersonInfo p : person) { 
					
			p.print(); // ��¹�� 1. 
			System.out.println(p.infoString()); //��¹�� 2 
		}
//		for(int i=0 ; i<person.length ; i++) { 
//			System.out.println(person[i].infoString());
//			person[i].print();
//		}
	}
}
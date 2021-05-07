package com.lec.ex0_janmuri;

public class PersonInfoMain {
	public static void main(String[] args) {
		
		int[] iArr = {10,20,30};
		
		PersonInfo[] person = {new PersonInfo("홍길동" ,20,'남'),
							   new PersonInfo("홍길순" ,22,'여'),
							   new PersonInfo()}; // 배열
		
		person[2].setName("홍길숙");
		person[2].setAge(21);
		person[2].setGender('여');
		
		for(PersonInfo p : person) { 
					
			p.print(); // 출력방법 1. 
			System.out.println(p.infoString()); //출력방법 2 
		}
//		for(int i=0 ; i<person.length ; i++) { 
//			System.out.println(person[i].infoString());
//			person[i].print();
//		}
	}
}
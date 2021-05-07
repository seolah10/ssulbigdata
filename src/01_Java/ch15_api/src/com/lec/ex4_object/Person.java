package com.lec.ex4_object;

public class Person {
	
	private long juminNo; // ex) 9010102222222
	
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public boolean equals(Object obj) {
		// Person p3;
		// p1.equals(p3) -> false / p1.equals(str1) -> false
		//p1.equals(p2) -> this�� p1, obj�� p2 
		// this.juminNo�� obj.juminNo�� ������ true�� return
		if(obj!=null && obj instanceof Person) {
			// juminNo == obj.juminNo ���� return
			return juminNo == ((Person)obj).juminNo;
		}		
		return false;
	}

}

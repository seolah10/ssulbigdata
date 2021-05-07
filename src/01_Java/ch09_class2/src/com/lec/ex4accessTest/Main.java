package com.lec.ex4accessTest;

import com.lec.ex3_access.AccessTest;

public class Main {
	public static void main(String[] args) {
		
		AccessTest obj = new AccessTest();

//		System.out.println(obj.defaultMember);   
//		System.out.println(obj.protectedMember); 패키지가 달라서 에러남
		System.out.println(obj.publicMember);
		
//		obj.defaultMethod();
//		obj.protectedMethod();
		obj.publicMethod();
			
		
	
	}

}

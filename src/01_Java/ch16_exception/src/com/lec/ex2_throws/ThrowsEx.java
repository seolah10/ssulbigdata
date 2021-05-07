package com.lec.ex2_throws;

public class ThrowsEx {
	
	public ThrowsEx() throws Exception {
		actionC();
	}
	
	private void actionC() throws Exception {
		System.out.println("actionC 전반부");
		actionB(); 		// 바로 아래 명령 수행 전에 actionB를 호출하여 actionB 메소드로 간다.
		System.out.println("actionC 후반부");
	}
	private void actionB() throws ArrayIndexOutOfBoundsException { 
		System.out.println("actionB 전반부");
		actionA();		//// 바로 아래 명령 수행 전에 actionA를 호출하여 actionA 메소드로 간다.
		System.out.println("actionB 후반부");
	}
	
	private void actionA() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionA 전반부");
		
		int[]arr = {0,1,2,3};
		System.out.println(arr[4]); // Exception 발생 
		System.out.println("actionA 후반부");
	}

}

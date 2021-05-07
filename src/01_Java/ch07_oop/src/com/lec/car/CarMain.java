package com.lec.car;

import java.util.Scanner;

public class CarMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Car myPorsche = new Car();
		Car yourPorshe = new Car(); // (아래 할당된 것이 없는 경우, new에서 들어간건 0이나 null로 청소해준다.)
		
		myPorsche.drive();
		yourPorshe.drive(); 
		myPorsche.park();
		myPorsche.race();
		myPorsche.setColor("red"); //myPorsche.color = "red"; 
		
		System.out.println("내 포르쉐 색상 : "+myPorsche.getColor());
		System.out.println("너 포르쉐 색상 : "+yourPorshe.getColor());
		System.out.println("내 포르쉐 배기량: "+myPorsche.getCc());	
	}

}

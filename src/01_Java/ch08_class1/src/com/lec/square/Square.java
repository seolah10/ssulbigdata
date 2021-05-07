package com.lec.square;
// class의 일반적인 모습
// Squre s1 = new Squre() - 매개변수 없는 버전
// Squre s2 = new Squre(10); - 매개변수 있는 버전
public class Square {
		private int side;
		public Square() { //매개변수 없는 생성자 => 생성자 오버로딩
			System.out.println("매개변수 없는 생성자 호출됨");
		}
		public Square(int side) { //매개변수 있는 생성자
			this.side = side; 
				System.out.println("매개변수 있는 생성자 호출됨");
		}
		public int area() { // 메소드
			return side * side;
		}
		public int getSide() { // getter & setter 
			return side;
		}
		public void setSide(int side) {
			this.side = side;
		}
}
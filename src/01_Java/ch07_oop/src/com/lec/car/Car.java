package com.lec.car;
// Car myPorsche = new Car();
// myPorshe.color = "red"
// 1203.7 PPT 참고
public class Car { //class는 반드시 대문자로 시작해야 한다. 
	private String color; // 보통 데이터엔 private(private은 외부에서 바로 못씀)
	private int cc;
	private int speed;

	public Car() { // 생성자 함수 = 리턴타입이 없고 클래스명과 같은 이름의 메소드
		// 디폴트 생성자 함수는 생성자 함수가 없을 때 JVM이 자동 생성
		// 객체 변수가 생성될 때 자동 호출 
		cc = 1000; 
		
	}
	public void drive() { // 보통 메소드엔 public
		speed = 60;
		System.out.println("운전한다 지금 속도 : "+speed);
	}
	void park() {
		speed = 0;
		System.out.println("주차한다 지금 속도 : "+speed);
	}
	void race() {
		speed = 120;
		System.out.println("레이싱한다 지금 속도 : "+speed);
	}
	// ~.setColor("red") 생성
	public void setColor(String color) { 
		this.color =  color; // this: '내 객체에' color를 넣어라
	}
	// ~.getColor()
	public String getColor() { // (객체의 color를 리턴할 것이므로 void가 없다.)
		return color;
	}
	//.getCc()
	public int getCc() {
		return cc;
	}
}

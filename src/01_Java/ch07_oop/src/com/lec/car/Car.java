package com.lec.car;
// Car myPorsche = new Car();
// myPorshe.color = "red"
// 1203.7 PPT ����
public class Car { //class�� �ݵ�� �빮�ڷ� �����ؾ� �Ѵ�. 
	private String color; // ���� �����Ϳ� private(private�� �ܺο��� �ٷ� ����)
	private int cc;
	private int speed;

	public Car() { // ������ �Լ� = ����Ÿ���� ���� Ŭ������� ���� �̸��� �޼ҵ�
		// ����Ʈ ������ �Լ��� ������ �Լ��� ���� �� JVM�� �ڵ� ����
		// ��ü ������ ������ �� �ڵ� ȣ�� 
		cc = 1000; 
		
	}
	public void drive() { // ���� �޼ҵ忣 public
		speed = 60;
		System.out.println("�����Ѵ� ���� �ӵ� : "+speed);
	}
	void park() {
		speed = 0;
		System.out.println("�����Ѵ� ���� �ӵ� : "+speed);
	}
	void race() {
		speed = 120;
		System.out.println("���̽��Ѵ� ���� �ӵ� : "+speed);
	}
	// ~.setColor("red") ����
	public void setColor(String color) { 
		this.color =  color; // this: '�� ��ü��' color�� �־��
	}
	// ~.getColor()
	public String getColor() { // (��ü�� color�� ������ ���̹Ƿ� void�� ����.)
		return color;
	}
	//.getCc()
	public int getCc() {
		return cc;
	}
}

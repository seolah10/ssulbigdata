package com.lec.ex04shape_void;

public class TestMain {

	public static void main(String[] args) {
		
//		Shape shape1 = new Circle(5);
//		Shape shape2 = new Rectangle(10,5);
//		Shape shape3 = new Triangle(5,10);

		Shape[] shape = { new Circle(5),
						  new Rectangle(10,5),
						  new Triangle(5,10) };
		
		
//		for(int i=0 ; i<=shape.length ; i++) { // ���� �߻� (����ܰ� ����)-���� ǥ�ð� ���µ� ����� ������ ���� ��
//			shape[i].draw();
//			shape[i].computeArea();
//		}
		
		for(Shape s : shape) {
			s.draw();
			s.computeArea();
		}
	}
}

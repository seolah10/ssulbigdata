package com.lec.square;
// class�� �Ϲ����� ���
// Squre s1 = new Squre() - �Ű����� ���� ����
// Squre s2 = new Squre(10); - �Ű����� �ִ� ����
public class Square {
		private int side;
		public Square() { //�Ű����� ���� ������ => ������ �����ε�
			System.out.println("�Ű����� ���� ������ ȣ���");
		}
		public Square(int side) { //�Ű����� �ִ� ������
			this.side = side; 
				System.out.println("�Ű����� �ִ� ������ ȣ���");
		}
		public int area() { // �޼ҵ�
			return side * side;
		}
		public int getSide() { // getter & setter 
			return side;
		}
		public void setSide(int side) {
			this.side = side;
		}
}
package com.lec.ex4_object;

public class Rectangle {

		private int width; 
		private int height;
		private String color;
		
		public Rectangle() {
			color = "����";
		}

		public Rectangle(int width, int height, String color) {
			this.width = width;
			this.height = height;
			this.color = color;
		}
		
		@Override
		public String toString() {
			return "[���� "+width+"cm, ���� "+height+"cm��  "+color +"�� �簢��]";
		}
		@Override
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(obj!=null && obj instanceof Rectangle) {
				boolean widthChk = width == ((Rectangle)obj).width;
				boolean heightChk = height == ((Rectangle)obj).height;
				boolean colorChk = color.equals(((Rectangle)obj).color);
					// (String ������ ==�� �ƴ϶� equal�� �Է��Ѵ�.)
				return widthChk && heightChk && colorChk;
			}
		return false; 
		}
		
}

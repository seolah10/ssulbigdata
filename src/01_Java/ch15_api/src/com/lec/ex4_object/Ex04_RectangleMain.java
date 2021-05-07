package com.lec.ex4_object;

public class Ex04_RectangleMain {

		public static void main(String[] args) {
			
			Rectangle[] rectangles = { new Rectangle(5, 6, "빨강"),
									   new Rectangle(5 ,6, "빨강"),
									   new Rectangle()};
			
			for (Rectangle rectangle : rectangles) {
				System.out.println(rectangle);
			}
			for (int i=0 ; i<rectangles.length-1 ; i++) {
				
				if(rectangles[i].equals(rectangles[i+1])) {
					System.out.println(i+"번째와 "+(i+1)+"번째는 같은 네모");
				}else {
					System.out.println(i+"번째와 "+(i+1)+"번째는 다른 네모");
				}
			}
		}
		
		
}

package com.lec.ex09lib;

public class Test {

	public static void main(String[] args) {
		
		Book book1 = new Book("890¤±","ÀÚ¹Ù","È«±æµ¿");
		Book book2 = new Book("890¤²","ÇÏµÓ","È«³¢¸®");
		
		book1.checkIn(); // ¹¹¶óÇÔ
		book1.checkOut("½Å±æµ¿", "201209"); // ´ëÃâÃ³¸®
		book1.checkOut("±è±æµ¿", "201209"); // ¹¹¶óÇÔ
		
		book1.printState();
		book1.printState();
	}
}

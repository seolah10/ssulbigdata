package com.lec.ex5_bookLib;

import java.util.Date;
import java.util.GregorianCalendar;

public class TestMain {

		public static void main(String[] args) {
				
			BookLib book = new BookLib("890��-01","java","���ڹ�");
			BookLib book1 = new BookLib("890��-02","hadoop","���ϵ�");
			
			try {
				book.checkOut("kim");
				book1.checkOut("lee");
				book.setCheckOutDate(new Date
						(new GregorianCalendar(2020,12,19).getTimeInMillis()));
				
				
			} catch (Exception e) {
					System.out.println(e.getMessage());
			
			} 
			System.out.println(book);
			System.out.println(book1);
		}
}

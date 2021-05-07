package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex10_dayCal {
	
	public static void main(String[] args) {
		
		Date checkoutDate = new Date(new GregorianCalendar(2020, 10, 15).getTimeInMillis());
		Date now = new Date();
		
		// now.getTime(): now시점의 millisec
		long diff = now.getTime() - checkoutDate.getTime();
		long day = diff / (1000*60*20*24); // diff를 일로 환산 
		
		if(day>14) { 
			day = day - 14;
			System.out.print("연체료 "+(day*100)+"원을 받으셨나요?(Y/N)?");
			Scanner sc = new Scanner(System.in);
			String ok = sc.next();
			
			if(!ok.equalsIgnoreCase("y")) {
				System.out.println("연체료를 내셔야 반납 처리됩니다.");
				return;
			}
		}
	}

}

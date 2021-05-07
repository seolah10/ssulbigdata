package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex10_dayCal {
	
	public static void main(String[] args) {
		
		Date checkoutDate = new Date(new GregorianCalendar(2020, 10, 15).getTimeInMillis());
		Date now = new Date();
		
		// now.getTime(): now������ millisec
		long diff = now.getTime() - checkoutDate.getTime();
		long day = diff / (1000*60*20*24); // diff�� �Ϸ� ȯ�� 
		
		if(day>14) { 
			day = day - 14;
			System.out.print("��ü�� "+(day*100)+"���� �����̳���?(Y/N)?");
			Scanner sc = new Scanner(System.in);
			String ok = sc.next();
			
			if(!ok.equalsIgnoreCase("y")) {
				System.out.println("��ü�Ḧ ���ž� �ݳ� ó���˴ϴ�.");
				return;
			}
		}
	}

}

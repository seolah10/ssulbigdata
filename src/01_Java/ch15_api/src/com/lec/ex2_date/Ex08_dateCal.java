package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex08_dateCal {

	public static void main(String[] args) {
		
		GregorianCalendar now = new GregorianCalendar();
		GregorianCalendar thatTime = new GregorianCalendar(2020, 10, 30, 9, 30, 0);

		long nowMillis = now.getTimeInMillis(); // 1970 ~ ����
		long thatMillis = thatTime.getTimeInMillis(); // 1970 ~ 2020.11.30
		long day = (nowMillis - thatMillis)/(1000*60*60*24);
		
		System.out.println("������ ���� "+day+"�� ����");
		
		Date thatDay = new Date
				(new GregorianCalendar(2020, 10, 30, 9, 30, 0).getTimeInMillis());
	}
}

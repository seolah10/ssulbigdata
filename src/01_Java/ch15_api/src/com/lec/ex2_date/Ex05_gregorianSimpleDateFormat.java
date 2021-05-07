package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Ex05_gregorianSimpleDateFormat {
	
	public static void main(String[] args) {
		
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("M�� d�� (E) a h�� m��");
		System.out.println(sdf.format(gc.getTime()));
	}

}

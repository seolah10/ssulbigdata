package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex06_DateSimpleDateFormat {

	public static void main(String[] args) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd(E) HH:mm");
		
		System.out.println(sdf.format(date));
	}
}

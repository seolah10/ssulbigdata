package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {

		private String num;
		private String name;
		private String part;
		private Date enterDate;
		
		public Sawon(String num, String name, String part) {
			this.num = num;
			this.name = name;
			this.part = part;
			enterDate = new Date();
		}
		public Sawon(String num, String name, String part, int y, int m, int d) {
			this.num = num;
			this.name = name;
			this.part = part;
			enterDate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
		}
		
		@Override
		public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

//		String result = String.format("[���]%s [�̸�]%s [�μ�]%s [�Ի���]%s",
//        								num, name, part, sdf.format(enterDate));
//		return result;
		String result = "[���]"+num +" [�̸�]"+name+" [�μ�]"+part+" [�Ի���]"+sdf.format(enterDate);
		return result;
		}
}

package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.lec.ex1_string.Friend;

public class Ex07_gcBirthday {

	public static void main(String[] args) {
		
		Friend[] friends = { new Friend("������","010-1212-1212","12-14"),
							 new Friend("������","010-2323-2323","12-12"),
							 new Friend("������","010-3434-3434","11-21")}; 
		
		// �迭���� ������ ������ ������� ��� ��� (�����ڰ� ������ ���ٰ� ����Ѵ�)
		
		GregorianCalendar now = new GregorianCalendar();
		
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		
		String monthString = (month<10) ? "0"+month : ""+month;
		String dayString = (day<10) ? "0"+day : ""+day;
		String today = monthString +"-"+dayString;
		System.out.println("������ "+today);
		
		boolean searchOk = false;
		System.out.println("������ �������Դϴ�.");
		
		for(int idx=0 ; idx<friends.length ; idx++) { 
			String birthday = friends[idx].getBirth();
			
			if(birthday.equals(today)) { 
				System.out.println(friends[idx]);
				searchOk = true;
			}
 		}
		if(!searchOk ) { 
			System.out.println("���� ������ ����� �����ϴ�.");
		}
	}
}

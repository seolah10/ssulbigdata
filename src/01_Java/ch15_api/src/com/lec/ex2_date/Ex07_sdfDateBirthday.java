package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.lec.ex1_string.Friend;

public class Ex07_sdfDateBirthday {

	public static void main(String[] args) {
		
		Friend[] friends = { new Friend("������","010-1212-1212","12-14"),
							 new Friend("������","010-2323-2323","12-12"),
							 new Friend("������","010-3434-3434","11-21")}; 
		
		// �迭���� ������ ������ ������� ��� ��� (�����ڰ� ������ ���ٰ� ����Ѵ�)
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");

		String today = sdf.format(now);
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

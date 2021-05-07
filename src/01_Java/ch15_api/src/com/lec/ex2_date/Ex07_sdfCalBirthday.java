package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.lec.ex1_string.Friend;

public class Ex07_sdfCalBirthday {

	public static void main(String[] args) {
		
		Friend[] friends = { new Friend("������","010-1212-1212","12-14"),
							 new Friend("������","010-2323-2323","12-12"),
							 new Friend("������","010-3434-3434","11-21")}; 
		
		// �迭���� ������ ������ ������� ��� ��� (�����ڰ� ������ ���ٰ� ����Ѵ�)
		
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		
		String today = sdf.format(now.getTime());
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


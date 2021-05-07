package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.lec.ex1_string.Friend;

public class Ex07_sdfCalBirthday {

	public static void main(String[] args) {
		
		Friend[] friends = { new Friend("김혜자","010-1212-1212","12-14"),
							 new Friend("한지민","010-2323-2323","12-12"),
							 new Friend("남주혁","010-3434-3434","11-21")}; 
		
		// 배열에서 오늘이 생일인 사람들의 목록 출력 (생일자가 없으면 없다고 출력한다)
		
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		
		String today = sdf.format(now.getTime());
		System.out.println("오늘은 "+today);
		
		boolean searchOk = false;
		System.out.println("오늘의 생일자입니다.");
		
		for(int idx=0 ; idx<friends.length ; idx++) { 
			String birthday = friends[idx].getBirth();
			
			if(birthday.equals(today)) { 
				System.out.println(friends[idx]);
				searchOk = true;
			}
 		}
		if(!searchOk ) { 
			System.out.println("오늘 생일인 사람은 없습니다.");
		}
	}
}


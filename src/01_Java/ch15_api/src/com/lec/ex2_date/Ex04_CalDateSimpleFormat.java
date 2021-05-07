package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* yyyy (년도 4자리) yy(년도 2자리)
 * M (9) MM (09) 월
 * d (9) dd (09) 일
 * E 요일
 * a 오전/오후
 * H 24시간
 * h 12시간
 * m 분
 * s 초
 * S 밀리세컨
 * w (이번 년도에 몇번째 주인지) W(이번 월에 몇번째 주인지) D(올해의 몇번째 날)
 */

public class Ex04_CalDateSimpleFormat {

		public static void main(String[] args) {
			
			Calendar cal = Calendar.getInstance();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
			
			// cal.getTime(): cal을 Date형으로 변환
			String today = sdf.format(cal.getTime());
			System.out.println(today);
		}
}

















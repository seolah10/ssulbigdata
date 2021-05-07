package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* yyyy (�⵵ 4�ڸ�) yy(�⵵ 2�ڸ�)
 * M (9) MM (09) ��
 * d (9) dd (09) ��
 * E ����
 * a ����/����
 * H 24�ð�
 * h 12�ð�
 * m ��
 * s ��
 * S �и�����
 * w (�̹� �⵵�� ���° ������) W(�̹� ���� ���° ������) D(������ ���° ��)
 */

public class Ex04_CalDateSimpleFormat {

		public static void main(String[] args) {
			
			Calendar cal = Calendar.getInstance();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
			
			// cal.getTime(): cal�� Date������ ��ȯ
			String today = sdf.format(cal.getTime());
			System.out.println(today);
		}
}

















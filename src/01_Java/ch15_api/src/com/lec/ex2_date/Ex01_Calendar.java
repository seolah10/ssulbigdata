package com.lec.ex2_date;

import java.util.Calendar;

public class Ex01_Calendar {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance(); // Calendar�� Singleton Pattern�̴�.
		System.out.println(cal);
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1; // �ý����� 0������ �����ϹǷ� +1�� ����� �Ѵ�.
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK); // 1(��), 2(��), 3(ȭ) ...
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 24�ð�  ex) ���� 3�� => 15�� 
		int hour = cal.get(Calendar.HOUR); // 12�ð�
		int ampm = cal.get(Calendar.AM_PM); // 0(am), 1(pm)
		int minute = cal.get(Calendar.MINUTE); 
		int second = cal.get(Calendar.SECOND); 
		int millisec =cal.get(Calendar.MILLISECOND); 
		
		System.out.printf("%d�� %d�� %d�� ", year, month, day);
		
		switch(week) { 
		
		case 1: System.out.print("�Ͽ���"); break;
		case 2: System.out.print("������"); break;
		case 3: System.out.print("ȭ����"); break;
		case 4: System.out.print("������"); break;
		case 5: System.out.print("�����"); break;
		case 6: System.out.print("�ݿ���"); break;
		case 7: System.out.print("�����"); break;
		}
		System.out.printf("%d�� %d�� %d�� %d\n", hour24, minute, second, millisec);
		
		System.out.printf("%tY�� %tm�� %td�� %tH�� %tM�� %tS��\n",
							cal, cal, cal, cal, cal, cal);
		System.out.printf("%1$tY�� 	%1$tm�� 	%1$td�� 	%1$tH�� 	%1$tM�� 	%1$tS��\n",cal); // 1$: �������� �ߺ��ɶ� ��� 
		
		System.out.print((ampm==0) ? "����" : "����");
		
		System.out.printf("%d�� %d�� %d��\n", hour, minute, second);
		
		System.out.printf("%tl�� %tM�� %tS��\n", cal, cal, cal);
		System.out.printf("%1$tl�� %1$tM�� %1$tS��\n", cal);
		
		// tY (��) tm(��) td(��) ta(����) tH(24��) tl(12��) tM(��) tS(��)
				// d(����) f(�Ǽ�) s(���ڿ�) c(����) b(true/false)
	}
}	




















package com.lec.ex2_date;

// ������ Ex1�� Calendar�� ����
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex02_GregorianCalendar {

	public static void main(String[] args) {
		
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc);
		
		int year = gc.get(Calendar.YEAR);
		int month = gc.get(Calendar.MONTH)+1; // �ý����� 0������ �����ϹǷ� +1�� ����� �Ѵ�.
		int day = gc.get(Calendar.DAY_OF_MONTH);
		int week = gc.get(Calendar.DAY_OF_WEEK); // 1(��), 2(��), 3(ȭ) ...
		int hour24 = gc.get(Calendar.HOUR_OF_DAY); // 24�ð�  ex) ���� 3�� => 15�� 
		int hour = gc.get(Calendar.HOUR); // 12�ð�
		int ampm = gc.get(Calendar.AM_PM); // 0(am), 1(pm)
		int minute = gc.get(Calendar.MINUTE); 
		int second = gc.get(Calendar.SECOND); 
		int millisec =gc.get(Calendar.MILLISECOND); 
		
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
							gc, gc, gc, gc, gc, gc);
		System.out.printf("%1$tY�� 	%1$tm�� 	%1$td�� 	%1$tH�� 	%1$tM�� 	%1$tS��\n",gc); // 1$: �������� �ߺ��ɶ� ��� 
		
		System.out.print((ampm==0) ? "����" : "����");
		
		System.out.printf("%d�� %d�� %d��\n", hour, minute, second);
		
		System.out.printf("%tl�� %tM�� %tS��\n", gc, gc, gc);
		System.out.printf("%1$tl�� %1$tM�� %1$tS��\n", gc);
		
		// tY (��) tm(��) td(��) ta(����) tH(24��) tl(12��) tM(��) tS(��)
				// d(����) f(�Ǽ�) s(���ڿ�) c(����) b(true/false)
	}
}	




















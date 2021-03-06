package com.lec.ex8_decimalFormat;

import java.text.DecimalFormat;

//숫자자리에 : #(있으면출력,없으면출력안함) 0(반드시 출력)
//, %, E

public class Ex01 {

	public static void main(String[] args) {
		
		double number = 1234567.8889;
		
		DecimalFormat df1 = new DecimalFormat("00000000.00000");
		System.out.println(df1.format(number));
		
		DecimalFormat df2 = new DecimalFormat("########.##");
		System.out.println(df2.format(number));
		
		DecimalFormat df3 = new DecimalFormat("#,###,###.00000");
		System.out.println(df3.format(number));
		
		DecimalFormat df4 = new DecimalFormat("#.#%");
		System.out.println(df4.format(number));
		
		DecimalFormat df5 = new DecimalFormat("#.#####E00");
		System.out.println(df5.format(number));
	}
}

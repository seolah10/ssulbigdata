package com.lec.ex8_decimalFormat;

import java.text.DecimalFormat;

//숫자자리에 : #(있으면출력,없으면출력안함) 0(반드시 출력)
//, %, E

public class Ex02 {
	
		public static void main(String[] args) {
			
				String[] patterns = { "00000000.00000",
									  "########.##",
									  "#,###,###.000",
									  "#.#%",
									  "#.#####E00"};
				
				double number = 1234567.8889;
				
				for(String pattern : patterns) {
					DecimalFormat df = new DecimalFormat(pattern);
					System.out.println(df.format(number));
				}
		}

}

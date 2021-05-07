package com.lex.ex13_final;

public class Animal {

	protected int speed;
	
	public void running() {
//		final int temp = 10;
//		temp += 5;
		
		speed +=5;
		System.out.println("¶Ù°í ÀÖ¾î¿ä! ÇöÀç ¼Óµµ: "+speed);
	}
	
	public final void stop() {
		
		speed = 0;
		System.out.println("¸ØÃã");
	}
}

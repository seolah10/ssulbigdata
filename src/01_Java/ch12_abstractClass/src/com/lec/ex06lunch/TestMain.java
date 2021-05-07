package com.lec.ex06lunch;

import com.lec.cons.LunchPriceEx06;

//Child1 c = new Child1(350,1000,100,300,800,350);
//Child2 c = new Child2(350,1000,100,300,800,350);

public class TestMain {

	public static void main(String[] args) {
		
		Child1 child1 = new Child1(LunchPriceEx06.RICE, 
								   LunchPriceEx06.BULGOGI,
								   LunchPriceEx06.SOUP,
								   LunchPriceEx06.BANANA,
								   LunchPriceEx06.MILK,
								   LunchPriceEx06.ALMOND);
		
		Child2 child2 = new Child2(LunchPriceEx06.RICE, 
								   LunchPriceEx06.BULGOGI,
								   LunchPriceEx06.SOUP,
								   LunchPriceEx06.BANANA,
								   LunchPriceEx06.MILK,
								   LunchPriceEx06.ALMOND);
								   
		
		System.out.println("child1형 식대: "+child1.calculate());
		System.out.println("child2형 식대: "+child2.calculate());
	}

}

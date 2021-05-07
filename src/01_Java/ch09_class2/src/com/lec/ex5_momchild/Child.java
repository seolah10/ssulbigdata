package com.lec.ex5_momchild;

public class Child {

		private String name; // <데이터>
		static MomPouch momPouch = new MomPouch();
		
		public Child(String name) { // <생성자>
			this.name = name;
		}
		
		public void takeMoney (int money) { // <메소드>
			
			if(momPouch.money >= money) { 
				momPouch.money -= money;
				
				System.out.println(name+"가 "+"money"+"가져가서 엄마지갑엔 "+momPouch.money);
			}
			else {
				System.out.println("name"+"가 돈을 못 받음"+"현재 엄마 돈은 "+momPouch.money);
			}
			// <getter & setter는 생략함>
		}
}

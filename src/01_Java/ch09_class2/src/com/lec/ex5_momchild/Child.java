package com.lec.ex5_momchild;

public class Child {

		private String name; // <������>
		static MomPouch momPouch = new MomPouch();
		
		public Child(String name) { // <������>
			this.name = name;
		}
		
		public void takeMoney (int money) { // <�޼ҵ�>
			
			if(momPouch.money >= money) { 
				momPouch.money -= money;
				
				System.out.println(name+"�� "+"money"+"�������� ���������� "+momPouch.money);
			}
			else {
				System.out.println("name"+"�� ���� �� ����"+"���� ���� ���� "+momPouch.money);
			}
			// <getter & setter�� ������>
		}
}

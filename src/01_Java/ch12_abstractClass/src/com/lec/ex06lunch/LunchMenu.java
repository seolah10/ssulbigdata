package com.lec.ex06lunch;

//Child1 c = new Child1(350,1000,100,300,800,350);
//Child2 c = new Child2(350,1000,100,300,800,350);

public abstract class LunchMenu {
	
	// <������> : ���� �޴��� ����
	private int rice;
	private int bulgogi;
	private int soup;
	private int banana;
	private int milk;
	private int almond;
	
	
	public LunchMenu(int rice, int bulgogi, int soup, int banana, int milk, int almond) {
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.soup = soup;
		this.banana = banana;
		this.milk = milk;
		this.almond = almond;
	}
	// �Ĵ� ����ϴ� �߻� �޼ҵ�
	public abstract int calculate();
	
	
	// getters 
	public int getRice() {
		return rice;
	}
	public int getBulgogi() {
		return bulgogi;
	}
	public int getSoup() {
		return soup;
	}
	public int getBanana() {
		return banana;
	}
	public int getMilk() {
		return milk;
	}
	public int getAlmond() {
		return almond;
	}
}
	



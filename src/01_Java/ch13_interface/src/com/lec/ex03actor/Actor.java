package com.lec.ex03actor;

public class Actor implements PoliceMan, FireFighter, Chef { // ��� �������� ���ҵ� ���� ����

	private String name;
	
	public Actor(String name) {
		this.name = name;
	}
	
	@Override
	public void makePizza() {
		System.out.println(name+"���ڸ� ���� �� �˾ƿ�");
		// TODO Auto-generated method stub

	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name+"�� ���İ�Ƽ�� ���� �� �˾ƿ�.");
		// TODO Auto-generated method stub

	}

	@Override
	public void outFire() {
		System.out.println(name+"�� ���� �� �� �־��");
		// TODO Auto-generated method stub

	}
	@Override
	public void saveMan() {
		System.out.println("�׸��� "+name+"�� �� �ӿ��� ������� ���س���.");
		// TODO Auto-generated method stub

	}

	@Override
	public void canCatchCriminal() {
		System.out.println(name+"�� ������ �� ��ƿ�");
		// TODO Auto-generated method stub

	}

	@Override
	public void canSearch() {
		System.out.println(name+"�� ���ǵ� ã�����");
		// TODO Auto-generated method stub

	}

}

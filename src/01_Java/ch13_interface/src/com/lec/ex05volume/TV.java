package com.lec.ex05volume;

//TV�� volumeUp()�̳� volumeDown() +2, -2�� ����

public class TV implements IVolume {

	private int volumeLevel; 
	
	public TV() { // ����Ʈ ������
		volumeLevel = 10;
	}
	public TV (int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	
	@Override
	public void volumeUp() {
		// 48 -> 50
		volumeLevel += 2;
		
		if(volumeLevel >= TV_MAX_VOLUME) {
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("������ �ִ��Դϴ�.");
		}
		else {
			System.out.println("TV ������ "+2+"��ŭ �÷� "+volumeLevel);
		}
		
	}
	@Override
	public void volumeUp(int level) {
		// 40 -> 50 
		volumeLevel += level;
		if(volumeLevel >= TV_MAX_VOLUME) {
			System.out.println("������ �ִ��Դϴ�.");
		}
		else {
			System.out.println("TV ������ "+level+"��ŭ �÷� "+volumeLevel);
		}
		
		
	}
	@Override
	public void volumeDown() {
		volumeLevel -= 2;
		
		if(volumeLevel <= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("���� �����Դϴ�.");
		}
		else {
			System.out.println("TV ������ "+2+"��ŭ ���� "+volumeLevel);
		}
		
		
	}
	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		
		if(volumeLevel <= MIN_VOLUME) {

			System.out.println("���� �����Դϴ�.");
		}
		else {
			System.out.println("TV ������ "+level+"��ŭ ���� "+volumeLevel);
		}
	}
}

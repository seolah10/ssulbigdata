package com.lec.ex05volume;

// ������ �ø��ų� ������ �������̽��� ����� �� �������̽��� Ȱ���� Ŭ����(Radio, TV)�� �����ô�. 

public interface IVolume {

	public int TV_MAX_VOLUME = 50;
	public int RADIO_MAX_VOLUME = 30; // MAX VOLUME ������ ������ Ŭ������ ���� ����
	public int MIN_VOLUME = 0;
	
	public void volumeUp();
	public void volumeUp(int level);
	public void volumeDown();
	public void volumeDown(int level);
	
	public default void mute() { // ����Ʈ �޼ҵ� 
		System.out.println("����ó�� �մϴ�.");
	}
}

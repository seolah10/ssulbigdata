package com.lec.ex05volume;

// 볼륨을 올리거나 내리는 인터페이스를 만들어 그 인터페이스를 활용한 클래스(Radio, TV)를 만들어봅시다. 

public interface IVolume {

	public int TV_MAX_VOLUME = 50;
	public int RADIO_MAX_VOLUME = 30; // MAX VOLUME 변수는 각각의 클래스로 빼도 무방
	public int MIN_VOLUME = 0;
	
	public void volumeUp();
	public void volumeUp(int level);
	public void volumeDown();
	public void volumeDown(int level);
	
	public default void mute() { // 디폴트 메소드 
		System.out.println("무음처리 합니다.");
	}
}

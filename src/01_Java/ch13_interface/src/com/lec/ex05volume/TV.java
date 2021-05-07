package com.lec.ex05volume;

//TV는 volumeUp()이나 volumeDown() +2, -2씩 조절

public class TV implements IVolume {

	private int volumeLevel; 
	
	public TV() { // 디폴트 생성자
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
			System.out.println("볼륨이 최대입니다.");
		}
		else {
			System.out.println("TV 볼륨을 "+2+"만큼 올려 "+volumeLevel);
		}
		
	}
	@Override
	public void volumeUp(int level) {
		// 40 -> 50 
		volumeLevel += level;
		if(volumeLevel >= TV_MAX_VOLUME) {
			System.out.println("볼륨이 최대입니다.");
		}
		else {
			System.out.println("TV 볼륨을 "+level+"만큼 올려 "+volumeLevel);
		}
		
		
	}
	@Override
	public void volumeDown() {
		volumeLevel -= 2;
		
		if(volumeLevel <= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("현재 무음입니다.");
		}
		else {
			System.out.println("TV 볼륨을 "+2+"만큼 내려 "+volumeLevel);
		}
		
		
	}
	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		
		if(volumeLevel <= MIN_VOLUME) {

			System.out.println("현재 무음입니다.");
		}
		else {
			System.out.println("TV 볼륨을 "+level+"만큼 내려 "+volumeLevel);
		}
	}
}

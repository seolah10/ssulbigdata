package com.lec.ex05volume;

//Radio는 volumeUp()이나 volumeDown() +1, -1씩 조절

public class Radio implements IVolume {
	
	private int volumeLevel;
	
	public Radio() {
		volumeLevel = 10;
	}
	public Radio(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() { // 29 -> 30 
		volumeLevel ++;
		
		if(volumeLevel >= RADIO_MAX_VOLUME) {
			volumeLevel = RADIO_MAX_VOLUME;
			System.out.println("볼륨이 최대입니다.");
		}
		else {
			System.out.println("Radio 볼륨을 "+1+"만큼 올려 "+volumeLevel);
		}

	}

	@Override
	
	public void volumeUp(int level) { //20 -> 30
		volumeLevel += level;
		
		if(volumeLevel >= RADIO_MAX_VOLUME) {
			volumeLevel = RADIO_MAX_VOLUME;
			System.out.println("볼륨이 최대입니다.");
		}
		else {
			System.out.println("Radio 볼륨을 "+level+"만큼 올려 "+volumeLevel);
		}


	}

	@Override
	public void volumeDown() {
		volumeLevel --;

		if(volumeLevel >= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("현재 무음입니다.");
		}
		else {
			System.out.println("Radio 볼륨을 "+1+"만큼 내려 "+volumeLevel);
		}


	}
	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;

		if(volumeLevel >= MIN_VOLUME) {
			volumeLevel = MIN_VOLUME;
			System.out.println("현재 무음입니다.");
		}
		else {
			System.out.println("Radio 볼륨을 "+level+"만큼 내려 "+volumeLevel);
		}
	}

}

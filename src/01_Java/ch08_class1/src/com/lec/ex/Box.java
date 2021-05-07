package com.lec.ex;
// 직육면체의 가로, 세로, 높이, 부피나 직사각형의 가로, 세로, 넓이를 구현하라. 
public class Box { //데이터
	public int width;
	public int height;
	public int depth;
	public int volume;

	public Box () {} // 디폴트 생성자
	
	public Box(int width, int height, int depth) { // 생성자 for Box
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.volume = volume;		
	}
	public Box(int width, int height) { // 생성자 for rectangular 
		this.width = width;
		this.height = height;
	}
	public void calNsetVolume() { // 메소드 
		if(depth==0) { 
			volume = width * height;
		}else {        
			volume = width*height*depth;
		}
	}	
		// setter & getter 
		public void setWidth(int width) {
			this.width = width; 
		}
		public int getWidth() {
			return width; 
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getHeight() {
			return height;
		}
		public void setDepth(int depth) {
			this.depth = depth;
		}
		public int getDepth() {
			return depth;
		}
		public void setVolume(int volume) {
			this.volume = volume;
		}
		public int getVolume() {
			return volume; 
		}
	}

















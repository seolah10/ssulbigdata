package com.lec.ex;
// ������ü�� ����, ����, ����, ���ǳ� ���簢���� ����, ����, ���̸� �����϶�. 
public class Box { //������
	public int width;
	public int height;
	public int depth;
	public int volume;

	public Box () {} // ����Ʈ ������
	
	public Box(int width, int height, int depth) { // ������ for Box
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.volume = volume;		
	}
	public Box(int width, int height) { // ������ for rectangular 
		this.width = width;
		this.height = height;
	}
	public void calNsetVolume() { // �޼ҵ� 
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

















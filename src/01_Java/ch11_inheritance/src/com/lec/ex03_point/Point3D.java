package com.lec.ex03_point;

// 3Â÷¿ø ÁÂÇ¥

public class Point3D extends Point {

	private int z;
	
	public void point3dPrint() {
		System.out.printf("3Â÷¿ø ÁÂÇ¥: %d,%d,%d\n",
									getX(),getY(),z);
	}
	public String point3dInfoString() {
		return "3Â÷¿ø ÁÂÇ¥: "+getX()+","+getY()+","+z;
	}
	
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}

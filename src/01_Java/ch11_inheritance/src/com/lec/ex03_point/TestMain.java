package com.lec.ex03_point;

public class TestMain {

	public static void main(String[] args) {
		
	Point point = new Point();
	
	point.setX(5);
	point.setY(6);
	
	point.pointPrint();
	System.out.println(point.pointInfoString());
	
	
	Point3D point3d = new Point3D();
	
	point3d.setX(10);
	point3d.setY(20);
	point3d.setZ(25);
	
	System.out.println(point3d.point3dInfoString());
	point3d.point3dPrint();
//	point3d.pointPrint();  ����� �޾Ҵ�. �ٸ� �Ⱦ� ��.. 
	}
}

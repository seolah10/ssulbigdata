package com.lec.ex01_store;

// �߻� Ŭ����(abstract class) : �߻� �޼ҵ尡 1�� �̻� �ִ� Ŭ����
// ch11.ex11store ��Ű���� �߻� �޼ҵ�� ... (���뵵 �ణ �ٸ�)

public abstract class HeadQuarterStore {

	private String name;
	
	public HeadQuarterStore(String name) { 
		this.name = name;
	}
	
	public abstract void kimchi(); // �߻� �޼ҵ�
	public abstract void budae();
	public abstract void bibim();
	public abstract void sundae();
	public abstract void gonggi();
	
 	public String getName() {
 		return name;
 	}
}
package com.lec.ex2_throws;

public class ThrowsEx {
	
	public ThrowsEx() throws Exception {
		actionC();
	}
	
	private void actionC() throws Exception {
		System.out.println("actionC ���ݺ�");
		actionB(); 		// �ٷ� �Ʒ� ��� ���� ���� actionB�� ȣ���Ͽ� actionB �޼ҵ�� ����.
		System.out.println("actionC �Ĺݺ�");
	}
	private void actionB() throws ArrayIndexOutOfBoundsException { 
		System.out.println("actionB ���ݺ�");
		actionA();		//// �ٷ� �Ʒ� ��� ���� ���� actionA�� ȣ���Ͽ� actionA �޼ҵ�� ����.
		System.out.println("actionB �Ĺݺ�");
	}
	
	private void actionA() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionA ���ݺ�");
		
		int[]arr = {0,1,2,3};
		System.out.println(arr[4]); // Exception �߻� 
		System.out.println("actionA �Ĺݺ�");
	}

}

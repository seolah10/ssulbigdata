package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
//		int i = 10; // ���� ����� �ʱ�ȭ (���� �ϳ����� ���� ���� �� ���� ����.)
		int[] iArr = {10,20,30,40,50}; // 1. �迭�� ����� �ʱ�ȭ
		iArr[1] = 200; // �迭�� index�� ���� (index:0~4)
		for (int idx=0 ; idx<5 ; idx++) { // �Ϲ� for��
			System.out.println(iArr[idx]);
		}
		int[] iArr2 = new int[5]; // 2. �迭 ���� ����� �迭 �޸� ���� Ȯ�� (������ �迭�� �켱 0���� Ȯ���Ǿ� ����)
		iArr2[0] = 777; // (0��° ���� 777�� �ٲ۴�)
		for(int idx=0 ; idx<iArr2.length ; idx++) { // �Ϲ� for�� (���� 5�� iArr2.length(�迭�� ����)�� �ٲپ� ǥ��)
			System.out.println(idx+"��°�� : "+iArr2[idx]);
		}
		int[] iArr3;// 3. �迭 ���� ���� 
		iArr3 = new int[5]; // 0 0 0 0 0
//		for(int idx=0 ; idx<iArr3.length ; idx++) { //�Ϲ� for������ �� ����
//		iArr3[idx] = idx+1;
		for(int temp : iArr3) { //Ȯ�� for������ �� ����
			temp = 10; //(�迭�� �ƴ϶� �迭�� ī���� temp�� 10�� ������� -�迭 ���� �ٲ��� �ʴ´�)
			// ������ ���� �ٲ� ���� Ȯ�� for���� ���� �ȵȴ�. 
		}
		for(int idx=0 ; idx<iArr3.length ; idx++) { //�Ϲ� for������ �� ���� 
			iArr[idx] = 10; 
		}
		for(int temp : iArr3 ) { // Ȯ�� for�� 
			System.out.println(temp);
		}
				
	}
}

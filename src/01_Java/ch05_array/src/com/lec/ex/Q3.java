package com.lec.ex;
// �Ʒ� 8���� ���� 1���� �迭�� �ʱ�ȭ�ϰ� �ִ밪�� �ּҰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
public class Q3 {
	public static void main(String[] args) {
		int[] array = {76,45,34,89,100,50,90,92};
		int sum=0, avg=0, max=0, min=999;
		for(int i=0 ; i<array.length ; i++) { 
			sum += array[i];
			if(array[i]>max) max = array[i];
			if(array[i]<min) min = array[i];
		}
		avg = sum/array.length;
		System.out.printf("�� �� = %d\t�� ��=%d\n",sum,avg);
		System.out.printf("�ִ밪 = %d\t�ּҰ�=%d\n",max,min);
	}
}

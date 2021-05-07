package com.lec.ex;
// 아래 8개의 값을 1차원 배열로 초기화하고 최대값과 최소값을 구하는 프로그램을 작성하시오.
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
		System.out.printf("합 계 = %d\t평 균=%d\n",sum,avg);
		System.out.printf("최대값 = %d\t최소값=%d\n",max,min);
	}
}

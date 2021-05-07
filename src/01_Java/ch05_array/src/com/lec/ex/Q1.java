package com.lec.ex;
// 다음 배열에 담긴 값을 더하는 프로그램을작성 int[] arr = {10,20,30,40,50}
public class Q1 {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int tot = 0;
		for(int idx=0 ; idx>arr.length ; idx++) {
			tot += arr[idx];
			}
		for(int temp : arr) {
			tot += temp;
		}
		System.out.println("종 합은 "+tot);
	}
}

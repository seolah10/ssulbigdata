package com.lec.ex1_list;

import java.util.ArrayList;

// array와 arrayList비교

public class Ex01_ArrayList {
	
		public static void main(String[] args) {
				
				String[] array = new String[3];
				array[0] = "str0";
				array[1] = "str1";
				array[2] = "str2";
				
				for(int idx=0 ; idx<array.length ; idx++) {
						System.out.println("array["+idx+"] = "+array[idx]);
				}
				for(String arr : array) { 
						System.out.println(arr);
				}
				
				ArrayList<String> arrayList = new ArrayList<String>();
				arrayList.add("str0"); // 0인덱스
				arrayList.add("str1"); // 1인덱스
				arrayList.add("str2"); // 2인덱스
				arrayList.add(1, "11111"); // 1인덱스에 "11111"삽입 
				
				for(int idx=0 ; idx<arrayList.size(); idx++) {
						System.out.println(idx+"번째 = "+arrayList.get(idx));
				}
				arrayList.remove(1); // 1번 인덱스값 삭제 (뒤의 인덱스들이 한번호씩 앞으로 앞당겨진다.)
				System.out.println(arrayList); // (삽입되었던 "11111"삭제됨)
				
				arrayList.clear(); // arrayList의 모든 데이터 삭제
				
//				if(arrayList.size() == 0) {
				if(arrayList.isEmpty()) { 
						System.out.println("arrayList 비워짐");
				}
				System.out.println(arrayList);
				
				arrayList = null;
				if(arrayList.size()==0) {
						System.out.println("arrayList 비워짐"); // (위와 결과비교)
				}
		}

}














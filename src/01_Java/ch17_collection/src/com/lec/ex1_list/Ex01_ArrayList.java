package com.lec.ex1_list;

import java.util.ArrayList;

// array�� arrayList��

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
				arrayList.add("str0"); // 0�ε���
				arrayList.add("str1"); // 1�ε���
				arrayList.add("str2"); // 2�ε���
				arrayList.add(1, "11111"); // 1�ε����� "11111"���� 
				
				for(int idx=0 ; idx<arrayList.size(); idx++) {
						System.out.println(idx+"��° = "+arrayList.get(idx));
				}
				arrayList.remove(1); // 1�� �ε����� ���� (���� �ε������� �ѹ�ȣ�� ������ �մ������.)
				System.out.println(arrayList); // (���ԵǾ��� "11111"������)
				
				arrayList.clear(); // arrayList�� ��� ������ ����
				
//				if(arrayList.size() == 0) {
				if(arrayList.isEmpty()) { 
						System.out.println("arrayList �����");
				}
				System.out.println(arrayList);
				
				arrayList = null;
				if(arrayList.size()==0) {
						System.out.println("arrayList �����"); // (���� �����)
				}
		}

}














package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex03_arrayListvsLinkedList {
	
		public static void main(String[] args) {
			
				ArrayList<String> array = new ArrayList<String>();
				LinkedList<String> linked = new LinkedList<String>();
				
				System.out.println("arrayList �� �ε����� �߰� �ð�: "+addSeqTime(array));
				System.out.println("linkedList �� �ε����� �߰� �ð�: "+addSeqTime(linked));
				
				System.out.println("arrayList �߰� �ε����� �߰� �ð�: "+addRandTime(array));
				System.out.println("linkedList �߰� �ε����� �߰� �ð�: "+addRandTime(linked));
				
				System.out.println("arrayList ������ ���� �ð�: "+removeSeqTime(array));
				System.out.println("linkedList ������ ���� �ð�: "+removeSeqTime(linked));
				
				System.out.println("arrayList �߰����� ���� �ð�: "+removeRandTime(array));
				System.out.println("linkedList �߰����� ���� �ð�: "+removeRandTime(linked));
		}
		private static long addSeqTime(List<String> list) {
				long start = System.currentTimeMillis(); // ���� �ð�
				for(int i=0 ; i<500000 ; i++) {
						list.add("���������� �߰�");
				}
				long end = System.currentTimeMillis(); // for�� ���� �� �ð�
				return end - start; 
		}
		private static long addRandTime(List<String> list) {
				long start = System.currentTimeMillis(); // for�� ���� �� �ð�
				for(int i=0 ; i<1000 ; i++) {
						list.add(100,"�߰��� �߰�");
				}
				long end = System.currentTimeMillis(); // for�� ���� �� �ð�
				return end - start; 
		}
		private static long removeSeqTime(List<String> list) {
				long start = System.currentTimeMillis(); // ���� �ð�
				for(int i=list.size()-1 ; i>1000 ; i--) {
						list.remove(i);
				}
				long end = System.currentTimeMillis(); // ���� �ð�
				return end - start; 
		}
		private static long removeRandTime(List<String> list) {
			long start = System.currentTimeMillis(); // for�� ���� �� �ð�
			for(int i=0 ; i<list.size() ; i++) {
					list.remove(0);
			}
			long end = System.currentTimeMillis(); // for�� ���� �� �ð�
			return end - start; 
	}

}
















package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {

		public static void main(String[] args) {
		
				HashSet<String> hashset = new HashSet<String>();
				hashset.add("str0");
				hashset.add("str1");
				hashset.add("str2");
				hashset.add("str3");
				System.out.println(hashset); // 얘도 출력순서는 자기 맘대로인가보군.. 
				System.out.println("hashset 사이즈: "+hashset.size());
				
				hashset.add("str2");
				System.out.println(hashset);
				System.out.println("hashset 사이즈: "+hashset.size());
				
				Iterator<String> iterator = hashset.iterator();
				
				while(iterator.hasNext()) {
						System.out.println(iterator.next());
				}
		}	
}

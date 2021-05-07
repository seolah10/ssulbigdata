package com.lec.ex2_map;

import java.util.Hashtable;
import java.util.Iterator;

public class Ex02_HashTable {
	
		public static void main(String[] args) {
			
				Hashtable<String, String> hashtable = new Hashtable<String, String>();
				
				hashtable.put("010-1212-1212","윤계상");
				hashtable.put("010-2323-2323","조규현");
				hashtable.put("010-3434-3434","유연석");
				hashtable.put("010-4545-4545","하정우");
				
				System.out.println(hashtable);
				
				Iterator<String> iterator = hashtable.keySet().iterator();
				
				while(iterator.hasNext()) {  // key값 가져오기
						String key = iterator.next();
						System.out.println(key+": "+hashtable.get(key)); // 출력순서는 마음대로임..
				}
				
		}

}

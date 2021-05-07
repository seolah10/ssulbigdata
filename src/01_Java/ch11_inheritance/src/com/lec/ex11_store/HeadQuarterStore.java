package com.lec.ex11_store;

import javax.print.DocFlavor.STRING;

//±èÄ¡Âî°³-5,000  ºÎ´ëÂî°³-6,000  ºñºö¹ä-6,000 ¼ø´ë±¹-5,000  °ø±â¹ä-1,000¿ø

public class HeadQuarterStore {

	private String name;
	
	public HeadQuarterStore(String name) { 
		this.name = name;
	}
	
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ 5,000¿ø");
	}
	public void budae() {
		System.out.println("ºÎ´ëÂî°³ 6,000¿ø");
	}
	public void bibim() {
		System.out.println("ºñºö¹ä 6,000¿ø");
	}
	public void sundae() {
		System.out.println("¼ø´ë±¹ 5,000¿ø");
	}
	public void gonggi() {
		System.out.println("°ø±â¹ä 1,000¿ø");
	}
	
	public String getName() {
		return name;
	}
}

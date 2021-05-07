package com.lec.ex01_store;

//±èÄ¡Âî°³-4,500 ºÎ´ëÂî°³-5,000 ºñºö¹ä-6,000 ¼ø´ë±¹-¾ÈÆÈ¾Æ °ø±â¹ä-1,000¿ø

public class StoreNum1 extends HeadQuarterStore { //

	public StoreNum1(String name) { 
		super(name);
	}
	
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ 4,500¿ø"); // alt+¹æÇâÅ° => ¼ø¼­ Á¶Á¤ °¡´É
	}
	@Override
	public void budae() {
		System.out.println("ºÎ´ëÂî°³ 5,000¿ø");
	}
	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä 6,000¿ø");
		
	}
	@Override
	public void sundae() {
		System.out.println("¼ø´ë±¹ ¾ÈÆÈ¾Æ¿ä");
	}
	@Override
	public void gonggi() {
		System.out.println("°ø±â¹ä 1,000¿ø");
		
	}
	
}

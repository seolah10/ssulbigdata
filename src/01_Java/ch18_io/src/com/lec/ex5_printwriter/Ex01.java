package com.lec.ex5_printwriter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex01 {
		
		public static void main(String[] args) {
				
				PrintWriter printwriter = null;
				OutputStream	os	    = null;
				Writer 		 writer		= null;
				
				try { 
//					os = new FileOutputStream("txtFile/out.txt");
//					printWriter = new PrintWriter(os);
//					writer = new FileWriter("txtFile/out.txt");
//					printWriter = new PrintWriter(writer); // 스트림객체생성
					printwriter = new PrintWriter("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\out.txt");
					System.out.println("안녕하세요\n 반갑습니다.");
					printwriter.println("안녕하세요 \r\n 반갑습니다.");
					
					System.out.println("개행자동 안될 예정 \n");
					printwriter.println("개행자동 안될 예정 \r\n");
					
					System.out.printf("%5s %3d %3d %5.1f\n", "홍길동", 99 ,98 ,98.5);
					printwriter.printf("%5s %3d %3d %5.1f\r\n", "홍길동",99 ,98 ,98.5);
					
					System.out.printf("%5s %3d %3d %5.1f\n", "김길동",100 ,100 ,95.5);
					printwriter.printf("%5s %3d %3d %5.1f\r\n", "김길동",100 ,100 ,95.5);
					
					
				} catch (IOException e) {
						System.out.println(e.getMessage());
					
				} finally {
						try { 
								if(printwriter!=null) printwriter.close();
								
						} catch (Exception e) {
								System.out.println(e.getMessage());
						}
				}
		}

}

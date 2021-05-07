package com.lec.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_OutputStream {

		public static void main(String[] args) {
			
				OutputStream os = null;
				
				try { 								// true 추가시: 파일에 append, 없으면 덮어씀
						os = new FileOutputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\out.txt"); // 1. 스트림객체 생성
						String str = "모두 다 안녕이 필요한 시국 \r\n";
						byte[] bs = str.getBytes(); // 스트링을 바이트배열로 변경
						os.write(bs);	// 2. 파일 쓰기 (예외 처리)
						
				} catch (FileNotFoundException e) { 
						System.out.println("파일 못 찾음"+e.getMessage());
						
				} catch (IOException e) {
						System.out.println("파일 쓰기 오류"+e.getMessage());
						
				} finally { 
						
						try {
								if(os != null) os.close(); 	// 3. 파일 닫기
							 
						} catch (Exception ignore) {
							
						}
				}
		}
}

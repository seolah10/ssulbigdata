package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//1. 스트림객체생성(inputStream, outputStream) 2.읽고쓰기(반복) 3.스트림닫기

public class Ex05_fileCopyStep1 {

		public static void main(String[] args) {
				
				InputStream is = null;
				OutputStream os = null;
				
				try { 
						is = new FileInputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\moomin.jpg"); // 입력
						os = new FileOutputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\moomin_copy.jpg"); // 출력
						
						int cnt = 0;
						while(true) { 
								++cnt;
								int i = is.read(); // 1byte (read자체가 int타입이다? // 여기서 예외처리)
								
								if(i == -1) break;
								os.write(i);
						}
					
					
				} catch (FileNotFoundException e) { 
						System.out.println("파일이나 폴더를 찾을 수 없음"+e.getMessage());
						
				} catch (IOException e) {
						System.out.println("읽고 쓸 때 예외 발생"+e.getMessage());
						
				} finally { 
						
						try { 
							if(is != null) is.close();
							if(os != null) os.close();
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
				}				
		}
}


// 파일 크기에 따라 시간이 걸리기도 한다.











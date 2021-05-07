package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//1.파일을연다(스트림객체생성) 2. 데이터를읽는다(1byte단위로 반복) 3.파일을닫는다
public class Ex01_inputStream {
	
		public static void main(String[] args) {
			
				InputStream is = null; // try-catch절 전에 스트림변수 선언

				try { 
						is = new FileInputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\1.txt"); // 1. 파일열기
						
						// 2.데이터읽기 (1byte단위로 반복)
						while(true) {
								int i = is.read(); // 예외발생 (catch절 추가)
								
								if(i == -1) 
										break; // (끝이 되면 멈춘다.)
//								System.out.println((char)i+" - 아스키코드: "+i); // 각 문자의 아스키코드가 출력됨
								System.out.println((char)i);
						} // while 
					
				} catch (FileNotFoundException e) {  // 파일을 찾지 못할 경우 예외처리
						System.out.println(e.getMessage());
						
				} catch (IOException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
				} finally { 
						// 3. 파일 닫기
						try { 
								if(is!=null) is.close();
								
						} catch (IOException e) {
							
						} // try-catch
				} // finally
		}

}










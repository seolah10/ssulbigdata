package com.lec.ex2_dataInputStreamOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_dataOutputStream {
		
		public static void main(String[] args) {
			
				OutputStream fos = null;
				DataOutputStream dos = null;
				
				try { // 보조스트림은 기본스트림을 통해서만 생성이 가능
						fos = new FileOutputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\dataFile.dat");
						dos = new DataOutputStream(fos); // 보조 스트림 객체
						
						dos.writeUTF("홍길동"); // String 저장 (저장 순서 지켜야 한다.)
						dos.writeInt(2); // int값 저장
						dos.writeDouble(95.9); // double값 저장
					
				} catch (FileNotFoundException e) { 
						System.out.println(e.getMessage());
					
				} catch (IOException e) {
						System.out.println(e.getMessage());
						
				} finally { 
					
						try { 
							if(dos != null) dos.close();
							if(fos != null) fos.close();

						} catch (IOException e) {
								System.out.println(e.getMessage());
							
						}
				}
				
				
		}
}

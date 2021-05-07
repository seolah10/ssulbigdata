package com.lec.ex4_bufferd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

// 키보드로부터 파일 이름을 입력받아 해당 파일 출력
public class Ex02_bufferedReaderKeyboard {
	
		public static void main(String[] args) {
			
				BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
				Reader 	   reader = null;
				BufferedReader br = null;
				
				System.out.println("읽어올 파일명을 입력하세요: ");
				
				try {  // txtFile/1.txt
						String filename = keyboard.readLine();
						File file = new File(filename); // 입력한 파일명의 파일 객체
						
						if(file.exists()) { 
								reader = new FileReader(file);
								br	   = new BufferedReader(reader);
								
								while(true) {
										String line = br.readLine();
										if(line==null) break;
										System.out.println(line);
								}
						} else {
								System.out.println("존재하지 않는 파일입니다.");
						}
					
				} catch (IOException e) {
						 System.out.println(e.getMessage());
						 
				} finally {
						try { 
								if(br!=null) br.close();
								if(reader!=null) reader.close();
							
						} catch (Exception e) {
								System.out.println(e.getMessage());
						}
				}
		}

}

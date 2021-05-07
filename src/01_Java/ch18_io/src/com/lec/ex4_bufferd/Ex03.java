package com.lec.ex4_bufferd;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

//1.키보드로부터 출력할 파일이름(txtFile/2.txt) 
//while
//		2.출력할 파일 내용은? (파일쓰기를 하기 싫으면 x)
//		2.키보드에서 입력한 내용을 파일로 씁니다 

public class Ex03 {
		
		public static void main(String[] args) {
			
				BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
				Writer writer = null;
				
				System.out.println("출력할 파일명을 입력하세요: ");
				
				try { 
						String filename = keyboard.readLine();
						writer = new FileWriter(filename, true);
						
						while(true) { 
								System.out.print("출력할 파일내용(원하지 않을 시 x): ");
								String content = keyboard.readLine();
								if(content.equalsIgnoreCase("x")) break;
								writer.write(content+"\r\n");
						}
					
				} catch (IOException e) {
						System.out.println(e.getMessage());

				} finally {
						try { 
								if(writer!=null) writer.close();
								if(keyboard!=null) keyboard.close();
							
						} catch (Exception ignore) {
							
						}
				}
		}

}

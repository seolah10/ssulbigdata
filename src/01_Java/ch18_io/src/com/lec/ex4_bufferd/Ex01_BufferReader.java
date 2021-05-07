package com.lec.ex4_bufferd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_BufferReader {

		public static void main(String[] args) {
			
				Reader reader = null;
				BufferedReader br = null;
				
				try { 
						reader = new FileReader("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\1.txt");
						br = new BufferedReader(reader);
						
						while(true) {
								String line = br.readLine();
								if(line == null) break;
								System.out.println(line);
						}
						
				} catch (IOException e) { 
						System.out.println(e.getMessage());
						
				} finally {
						try {
								if(br!=null) br.close();
								if(reader!=null) reader.close();
							
						} catch (IOException e) {
							
						}
				}
		}
}

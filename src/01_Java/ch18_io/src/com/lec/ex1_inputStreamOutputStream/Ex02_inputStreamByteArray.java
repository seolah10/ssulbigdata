package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_inputStreamByteArray {
		
		public static void main(String[] args) {
			
				InputStream is = null; 
				
				try {	
						is = new FileInputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\1.txt");
						byte[] bs = new byte[10];
						
						while(true) {
									//int i = is.read(); // 1byte만 
									int readByteCount = is.read(bs); // (10byte씩 읽을 수 있다.)
									
									if (readByteCount == -1) break; // (더이상 읽을 것이 없을 때 -1를 수행한다.)
									
									for(int i=0 ; i<readByteCount ; i++) { 
											System.out.print((char)bs[i]);
									}
						}
						
				} catch (FileNotFoundException e) {
						System.out.println(e.getMessage());
						
				} catch (IOException e) {
						System.out.println(e.getMessage());

				} finally { 
					
					try { 
							if(is != null) is.close();
						
					} catch (IOException e) { 
							System.out.println(e.getMessage());

					} // try-catch
				} // finally 
		}
}

















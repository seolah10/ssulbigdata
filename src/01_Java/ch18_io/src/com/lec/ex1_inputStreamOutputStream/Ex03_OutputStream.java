package com.lec.ex1_inputStreamOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_OutputStream {
	
		public static void main(String[] args) {
			
				OutputStream os = null;
				
				try {
						os = new FileOutputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile");
						byte[] bs = {'H','e','l','l','o','\r','\n','J','A','V','A'};
						
						for(int i=0 ; i<bs.length ; i++) {
								os.write(bs[i]); 	// 2. 파일에 데이터 쓰기(반복)
						}
						
						System.out.println("성공");
						
				} catch (IOException e) {
						System.out.println(e.getMessage());
						
				} finally {
					
						try { 
								if(os != null) os.close(); // 3. 파일 닫기
							
						} catch (Exception e) {
								System.out.println(e.getMessage());
								
						}
				}
		}

}
// out.txt 파일에 Hello JAVA가 출력된다.
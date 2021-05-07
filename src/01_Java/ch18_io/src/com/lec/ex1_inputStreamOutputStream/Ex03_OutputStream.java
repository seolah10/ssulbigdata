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
								os.write(bs[i]); 	// 2. ���Ͽ� ������ ����(�ݺ�)
						}
						
						System.out.println("����");
						
				} catch (IOException e) {
						System.out.println(e.getMessage());
						
				} finally {
					
						try { 
								if(os != null) os.close(); // 3. ���� �ݱ�
							
						} catch (Exception e) {
								System.out.println(e.getMessage());
								
						}
				}
		}

}
// out.txt ���Ͽ� Hello JAVA�� ��µȴ�.
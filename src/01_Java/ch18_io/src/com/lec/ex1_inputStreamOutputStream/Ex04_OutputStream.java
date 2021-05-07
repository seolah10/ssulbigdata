package com.lec.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_OutputStream {

		public static void main(String[] args) {
			
				OutputStream os = null;
				
				try { 								// true �߰���: ���Ͽ� append, ������ ���
						os = new FileOutputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\out.txt"); // 1. ��Ʈ����ü ����
						String str = "��� �� �ȳ��� �ʿ��� �ñ� \r\n";
						byte[] bs = str.getBytes(); // ��Ʈ���� ����Ʈ�迭�� ����
						os.write(bs);	// 2. ���� ���� (���� ó��)
						
				} catch (FileNotFoundException e) { 
						System.out.println("���� �� ã��"+e.getMessage());
						
				} catch (IOException e) {
						System.out.println("���� ���� ����"+e.getMessage());
						
				} finally { 
						
						try {
								if(os != null) os.close(); 	// 3. ���� �ݱ�
							 
						} catch (Exception ignore) {
							
						}
				}
		}
}

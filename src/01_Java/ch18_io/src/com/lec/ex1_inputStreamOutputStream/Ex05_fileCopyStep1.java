package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//1. ��Ʈ����ü����(inputStream, outputStream) 2.�а���(�ݺ�) 3.��Ʈ���ݱ�

public class Ex05_fileCopyStep1 {

		public static void main(String[] args) {
				
				InputStream is = null;
				OutputStream os = null;
				
				try { 
						is = new FileInputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\moomin.jpg"); // �Է�
						os = new FileOutputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\moomin_copy.jpg"); // ���
						
						int cnt = 0;
						while(true) { 
								++cnt;
								int i = is.read(); // 1byte (read��ü�� intŸ���̴�? // ���⼭ ����ó��)
								
								if(i == -1) break;
								os.write(i);
						}
					
					
				} catch (FileNotFoundException e) { 
						System.out.println("�����̳� ������ ã�� �� ����"+e.getMessage());
						
				} catch (IOException e) {
						System.out.println("�а� �� �� ���� �߻�"+e.getMessage());
						
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


// ���� ũ�⿡ ���� �ð��� �ɸ��⵵ �Ѵ�.











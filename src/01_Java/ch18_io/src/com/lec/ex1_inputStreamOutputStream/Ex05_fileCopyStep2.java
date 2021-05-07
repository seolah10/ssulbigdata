package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//1. ��Ʈ����ü����(inputStream, outputStream) 2.�а���(�ݺ�) 3.��Ʈ���ݱ�

public class Ex05_fileCopyStep2 {

		public static void main(String[] args) {
				
				InputStream is = null;
				OutputStream os = null;
				
				try { 
						is = new FileInputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\moomin.jpg"); // �Է�
						os = new FileOutputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\moomin_copy.jpg"); // ���
						
						int cnt = 0;
						byte[] bs = new byte[1024]; // 1KB�� �� �迭�� �о���̱� ���� (step1���� 1/1000���� ��������.)
 						
						while(true) { 
								++cnt;
								int readByteCount = is.read(bs); 
								
								if(readByteCount == -1) break;
								// bs�迭�� 0�� index���� readByteCount ����Ʈ ��ŭ�� ���Ͽ� ����
								os.write(bs, 0, readByteCount);
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











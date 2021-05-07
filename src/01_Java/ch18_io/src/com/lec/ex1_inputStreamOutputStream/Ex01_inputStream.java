package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//1.����������(��Ʈ����ü����) 2. �����͸��д´�(1byte������ �ݺ�) 3.�������ݴ´�
public class Ex01_inputStream {
	
		public static void main(String[] args) {
			
				InputStream is = null; // try-catch�� ���� ��Ʈ������ ����

				try { 
						is = new FileInputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\1.txt"); // 1. ���Ͽ���
						
						// 2.�������б� (1byte������ �ݺ�)
						while(true) {
								int i = is.read(); // ���ܹ߻� (catch�� �߰�)
								
								if(i == -1) 
										break; // (���� �Ǹ� �����.)
//								System.out.println((char)i+" - �ƽ�Ű�ڵ�: "+i); // �� ������ �ƽ�Ű�ڵ尡 ��µ�
								System.out.println((char)i);
						} // while 
					
				} catch (FileNotFoundException e) {  // ������ ã�� ���� ��� ����ó��
						System.out.println(e.getMessage());
						
				} catch (IOException e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
				} finally { 
						// 3. ���� �ݱ�
						try { 
								if(is!=null) is.close();
								
						} catch (IOException e) {
							
						} // try-catch
				} // finally
		}

}










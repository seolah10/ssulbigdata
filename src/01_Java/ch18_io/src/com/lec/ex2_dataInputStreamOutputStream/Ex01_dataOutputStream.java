package com.lec.ex2_dataInputStreamOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_dataOutputStream {
		
		public static void main(String[] args) {
			
				OutputStream fos = null;
				DataOutputStream dos = null;
				
				try { // ������Ʈ���� �⺻��Ʈ���� ���ؼ��� ������ ����
						fos = new FileOutputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\dataFile.dat");
						dos = new DataOutputStream(fos); // ���� ��Ʈ�� ��ü
						
						dos.writeUTF("ȫ�浿"); // String ���� (���� ���� ���Ѿ� �Ѵ�.)
						dos.writeInt(2); // int�� ����
						dos.writeDouble(95.9); // double�� ����
					
				} catch (FileNotFoundException e) { 
						System.out.println(e.getMessage());
					
				} catch (IOException e) {
						System.out.println(e.getMessage());
						
				} finally { 
					
						try { 
							if(dos != null) dos.close();
							if(fos != null) fos.close();

						} catch (IOException e) {
								System.out.println(e.getMessage());
							
						}
				}
				
				
		}
}

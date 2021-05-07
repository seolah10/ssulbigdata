package com.lec.ex2_dataInputStreamOutputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_DataInputStream {

		public static void main(String[] args) {
			
				InputStream fis = null;
				DataInputStream dis = null;
				
				try { 
						fis = new FileInputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\dataFile.dat");
						dis = new DataInputStream(fis);
						
						String name = dis.readUTF();
						int grade = dis.readInt();
						double score = dis.readDouble();
						
						System.out.println("파일로부터 입력받은 값은 "+name+"\t"+grade+"\t"+score);
				
				} catch (IOException e) { 
						System.out.println(e.getMessage());
						
				} finally { 
						
						try { 
								if(dis != null) dis.close();
								if(fis != null) fis.close();
							
						} catch (Exception e) { 
								System.out.println(e.getMessage());
						}
					
				}
		}
}

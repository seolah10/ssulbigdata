package com.lec.ex3_writerReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {
		
		public static void main(String[] args) {
			
				Writer  writer = null;
				
				try {  	
						writer = new FileWriter("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\outText.txt");
						String str = "�ȳ��ϼ���?";
						writer.write(str+"\n");
						String str1 = "��ڴ� ���� ���̳�";
						writer.write(str1);
						
				} catch (IOException e) { 
						System.out.println(e.getMessage());
						
				} finally { 
						try { 
								if(writer!=null) writer.close();
							
						} catch (Exception ignore) {
							
						}
				
				}
		}
	

}

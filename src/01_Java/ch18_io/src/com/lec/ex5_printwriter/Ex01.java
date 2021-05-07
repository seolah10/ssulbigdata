package com.lec.ex5_printwriter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex01 {
		
		public static void main(String[] args) {
				
				PrintWriter printwriter = null;
				OutputStream	os	    = null;
				Writer 		 writer		= null;
				
				try { 
//					os = new FileOutputStream("txtFile/out.txt");
//					printWriter = new PrintWriter(os);
//					writer = new FileWriter("txtFile/out.txt");
//					printWriter = new PrintWriter(writer); // ��Ʈ����ü����
					printwriter = new PrintWriter("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\out.txt");
					System.out.println("�ȳ��ϼ���\n �ݰ����ϴ�.");
					printwriter.println("�ȳ��ϼ��� \r\n �ݰ����ϴ�.");
					
					System.out.println("�����ڵ� �ȵ� ���� \n");
					printwriter.println("�����ڵ� �ȵ� ���� \r\n");
					
					System.out.printf("%5s %3d %3d %5.1f\n", "ȫ�浿", 99 ,98 ,98.5);
					printwriter.printf("%5s %3d %3d %5.1f\r\n", "ȫ�浿",99 ,98 ,98.5);
					
					System.out.printf("%5s %3d %3d %5.1f\n", "��浿",100 ,100 ,95.5);
					printwriter.printf("%5s %3d %3d %5.1f\r\n", "��浿",100 ,100 ,95.5);
					
					
				} catch (IOException e) {
						System.out.println(e.getMessage());
					
				} finally {
						try { 
								if(printwriter!=null) printwriter.close();
								
						} catch (Exception e) {
								System.out.println(e.getMessage());
						}
				}
		}

}

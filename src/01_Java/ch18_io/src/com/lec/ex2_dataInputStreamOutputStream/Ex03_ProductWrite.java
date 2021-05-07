package com.lec.ex2_dataInputStreamOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

//n�� �Է��Ҷ����� ����Է�(���Ǹ�, ����, ������)�޾� ���Ͽ� ����

public class Ex03_ProductWrite {
		
		public static void main(String[] args) {
			
				Scanner sc = new Scanner(System.in);
				String answer;
				
				OutputStream 	 fos = null;
				DataOutputStream dos = null;
				
				try { 
						fos = new FileOutputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\dataFile.dat",true);
						dos = new DataOutputStream(fos);
						
						while(true) { 
								System.out.print("��� �� �ֳ���(Y/N)? ");
								answer = sc.next();
								
								if(answer.equalsIgnoreCase("n")) 
										break;
								else if (answer.equalsIgnoreCase("y")) { 
										System.out.print("���ǰ��: ");
										dos.writeUTF(sc.next());
										System.out.print("���ǰ ����: ");
										dos.writeInt(sc.nextInt());
										System.out.print("���ǰ ����: ");
										dos.write(sc.nextInt());
								}
						}
					
				} catch (FileNotFoundException e) { 
						System.out.println(e.getMessage());
						
				} catch (IOException e) {
						System.out.println(e.getMessage());
						
				} finally { 
						try { 
								if(dos!=null) dos.close();
								if(fos!=null) fos.close();
							
						} catch (Exception e) { 
								System.out.println(e.getMessage());
						}
				}
		}

}

package com.lec.ex2_dataInputStreamOutputStream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

//n를 입력할때까지 재고입력(물건명, 가격, 재고수량)받아 파일에 저장

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
								System.out.print("재고가 더 있나요(Y/N)? ");
								answer = sc.next();
								
								if(answer.equalsIgnoreCase("n")) 
										break;
								else if (answer.equalsIgnoreCase("y")) { 
										System.out.print("재고품명: ");
										dos.writeUTF(sc.next());
										System.out.print("재고품 가격: ");
										dos.writeInt(sc.nextInt());
										System.out.print("재고품 수량: ");
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

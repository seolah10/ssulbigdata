package com.lec.ex2_dataInputStreamOutputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Ex04_ProductList {
	
		public static void main(String[] args) {
			
				ArrayList<Product> products = new ArrayList<Product>();
				
				InputStream 	fis = null;
				DataInputStream dis = null;
				
				String name;
				int price, ps;
				
				try { 
						fis = new FileInputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\dataFile.dat"); // 보조스트림 열기
						dis = new DataInputStream(fis);  // 기본스트림 열기
						
						while(true) {
								name = dis.readUTF(); // 재고품명
								price = dis.readInt(); // 재고품 가격
								ps = dis.readInt(); // 재고품 수량
								
								products.add(new Product(name, price, ps));
						}
						
				} catch (FileNotFoundException e) {
						System.out.println(e.getMessage());
						
				} catch (IOException e) {
						System.out.println("product.dat 파일 내용을 출력");
						
						
				} finally {
						try { 
							if(dis!=null) dis.close();
							if(fis!=null) fis.close();
							
						} catch (Exception e) {
								System.out.println(e.getMessage());
						} // try-catch
			
				} // try-catch-finally
				for(Product p : products) {
						System.out.println(p);
				}
				System.out.println("이상 "+products.size()+"개 재고입력됨");
		}

}

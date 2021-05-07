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
						fis = new FileInputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\dataFile.dat"); // ������Ʈ�� ����
						dis = new DataInputStream(fis);  // �⺻��Ʈ�� ����
						
						while(true) {
								name = dis.readUTF(); // ���ǰ��
								price = dis.readInt(); // ���ǰ ����
								ps = dis.readInt(); // ���ǰ ����
								
								products.add(new Product(name, price, ps));
						}
						
				} catch (FileNotFoundException e) {
						System.out.println(e.getMessage());
						
				} catch (IOException e) {
						System.out.println("product.dat ���� ������ ���");
						
						
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
				System.out.println("�̻� "+products.size()+"�� ����Էµ�");
		}

}

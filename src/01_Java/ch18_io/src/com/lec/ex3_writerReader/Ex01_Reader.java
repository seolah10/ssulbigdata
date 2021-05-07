package com.lec.ex3_writerReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_Reader {

	public static void main(String[] args) {
		
		Reader reader = null;
		
		try { 
				reader = new FileReader("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\1.txt");
				
				while(true) { 
						int i = reader.read();
						if(i == -1) break;
						System.out.println((char)i);
				}
				
		} catch (FileNotFoundException e) { 
				System.out.println(e.getMessage());
		
		} catch (IOException e) {
				System.out.println(e.getMessage());
			
		} finally {
				try { 
						if(reader!=null) reader.close();
					
				} catch(Exception e) { 
						System.out.println(e.getMessage());
					
				}
	
		}
		
				
}

}

package com.lec.ex1_inputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//1. 스트림객체생성(inputStream, outputStream) 2.읽고쓰기(반복) 3.스트림닫기

public class Ex05_fileCopyStep3 {

		public static void main(String[] args) {
				
				InputStream is = null;
				OutputStream os = null;
				
				try { 
						File originalFile = new File ("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\moomin.jpg");
						
//						if(originalFile.exists()) { 
//								System.out.println("파일 존재함");
//						} else { 
//								System.out.println("존재하지 않는 파일입니다. 파일명을 다시 확인하세요.");
//						}
//						
						is = new FileInputStream(originalFile); // 입력
						os = new FileOutputStream("D:\\BigData\\srcLecture\\1_Java\\ch18_io\\src\\txtFile\\moomin_copy.jpg"); // 출력
						
						int cnt = 0;
						byte[] bs = new byte[(int)originalFile.length()]; // 1KB씩 이 배열에 읽어들이기 위함
 																		  // []안의 수가 Integer가 허용하는 범위를 넘어서면 안된다.
						while(true) { 
								++cnt;
								int readByteCount = is.read(bs); 
								
								if(readByteCount == -1) break;
								// bs배열에 0번 index부터 readByteCount 바이트 만큼만 파일에 쓰기
								os.write(bs, 0, readByteCount);
						}
						System.out.println(cnt+"번 반복문 실행 후 파일 복사 성공");
					
				} catch (FileNotFoundException e) { 
						System.out.println("파일이나 폴더를 찾을 수 없음"+e.getMessage());
						
				} catch (IOException e) {
						System.out.println("읽고 쓸 때 예외 발생"+e.getMessage());
						
				} finally { 
						
						try { 
							if(is != null) is.close();
							if(os != null) os.close();
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
				}				
		}
}


// 파일 크기에 따라 시간이 걸리기도 한다.











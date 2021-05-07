package com.lec.ex5_bookLib;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookMain {
	
		public static void main(String[] args) {
			
				BookLib[] books = { new BookLib ("890ㄱ-01","java","유재석"),
									new BookLib ("890ㄱ-02","python","강호동"),
									new BookLib ("890ㄱ-03","html", "이경규"),
									new BookLib ("890ㄱ-04","hadoop","김용만"),
									new BookLib ("890ㄱ-05", "r", "신동엽")};
				
				Scanner sc = new Scanner(System.in);
				int fn; // 기능번호
				int idx; // 처리할 책의 index
				String bTitle, borrower;
				
				do { 
					System.out.println("0:전체 도서상태 열람 / 1:대출 / 2:반납 / 그 외: 종료");
					
					try { 
							fn = sc.nextInt();
							
					} catch (InputMismatchException e) { 
							System.out.println("0,1,2 외 다른 문자를 입력하시면 종료됩니다.");
							break;
						
					}
					
					switch(fn) {
					
					case 0: 
							for(BookLib book : books) {
								System.out.println(book);
							}
							break;
					case 1: 
						//대출처리 1.책이름입력 2.책검색 3.책상태확인 4.대출자입력 5.대출처리 
						System.out.println("대출 도서명: "); // 1. 책이름입력
						sc.nextLine();
						bTitle = sc.nextLine();
						
						for(idx=0 ; idx<books.length ; idx++) {	 // 2. 책검색 
							if(books[idx].getBookTitle().equals(bTitle)) { 
								break; // 검색 도서 발견시 
							}
						}
						if(idx == books.length) { 	// 검색 도서를 발견하지 못한 경우
							System.out.println("해당 도서를 찾을 수 없습니다.");
						
						} else { 
								if(books[idx].getState() == BookLib.STATE_BORROWED) { // 3. 책상태 확인
									System.out.println("해당 도서는 현재 대출중입니다.");
								
								} else { // 4. 대출자 입력
									System.out.println("대출자 성명: ");
									borrower = sc.next();
									 
									try { 
											books[idx].checkOut(borrower); // 5. 대출처리
									} catch (Exception e) { 
											System.out.println(e.getMessage());
									}
									
								} // if - 3. 책상태확인
							
						} // if - 검색 도서를 발견하지 못한 경우
						break;
						
					case 2:
						//반납처리 1.책이름 2.책검색 3.반납처리
							System.out.println("반납 도서명: "); // 1. 책이름
							sc.nextLine();
							bTitle = sc.nextLine(); // 책이름에 있을 space까지 받음
						
							for(idx=0 ; idx<books.length ; idx++) { // 2. 책 검색
							
								if(books[idx].getBookTitle().equals(bTitle)) {
									break; // 도서를 찾았으니 빠져나간다.
								}
							} // for 
							if(idx == books.length) { 
								System.out.println("본 도서관에서 해당 도서를 찾을 수 없습니다.");
							
							} else {
								
								try { 
										books[idx].checkIn(); // 3. 반납 처리
										
								} catch (Exception e) { 
										System.out.println(e.getMessage());
								
								}
							}  // if 
							break;
							
						default:
								System.out.println("0,1,2 외 문자를 입력하시면 종료됩니다.");
								// System.exit(0);
					} // switch
				
				} while (fn==0 || fn==1 || fn==2);
				sc.close();
		}
}


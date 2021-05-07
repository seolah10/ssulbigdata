package com.lec.ex5_bookLib;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookMain {
	
		public static void main(String[] args) {
			
				BookLib[] books = { new BookLib ("890��-01","java","���缮"),
									new BookLib ("890��-02","python","��ȣ��"),
									new BookLib ("890��-03","html", "�̰��"),
									new BookLib ("890��-04","hadoop","��븸"),
									new BookLib ("890��-05", "r", "�ŵ���")};
				
				Scanner sc = new Scanner(System.in);
				int fn; // ��ɹ�ȣ
				int idx; // ó���� å�� index
				String bTitle, borrower;
				
				do { 
					System.out.println("0:��ü �������� ���� / 1:���� / 2:�ݳ� / �� ��: ����");
					
					try { 
							fn = sc.nextInt();
							
					} catch (InputMismatchException e) { 
							System.out.println("0,1,2 �� �ٸ� ���ڸ� �Է��Ͻø� ����˴ϴ�.");
							break;
						
					}
					
					switch(fn) {
					
					case 0: 
							for(BookLib book : books) {
								System.out.println(book);
							}
							break;
					case 1: 
						//����ó�� 1.å�̸��Է� 2.å�˻� 3.å����Ȯ�� 4.�������Է� 5.����ó�� 
						System.out.println("���� ������: "); // 1. å�̸��Է�
						sc.nextLine();
						bTitle = sc.nextLine();
						
						for(idx=0 ; idx<books.length ; idx++) {	 // 2. å�˻� 
							if(books[idx].getBookTitle().equals(bTitle)) { 
								break; // �˻� ���� �߽߰� 
							}
						}
						if(idx == books.length) { 	// �˻� ������ �߰����� ���� ���
							System.out.println("�ش� ������ ã�� �� �����ϴ�.");
						
						} else { 
								if(books[idx].getState() == BookLib.STATE_BORROWED) { // 3. å���� Ȯ��
									System.out.println("�ش� ������ ���� �������Դϴ�.");
								
								} else { // 4. ������ �Է�
									System.out.println("������ ����: ");
									borrower = sc.next();
									 
									try { 
											books[idx].checkOut(borrower); // 5. ����ó��
									} catch (Exception e) { 
											System.out.println(e.getMessage());
									}
									
								} // if - 3. å����Ȯ��
							
						} // if - �˻� ������ �߰����� ���� ���
						break;
						
					case 2:
						//�ݳ�ó�� 1.å�̸� 2.å�˻� 3.�ݳ�ó��
							System.out.println("�ݳ� ������: "); // 1. å�̸�
							sc.nextLine();
							bTitle = sc.nextLine(); // å�̸��� ���� space���� ����
						
							for(idx=0 ; idx<books.length ; idx++) { // 2. å �˻�
							
								if(books[idx].getBookTitle().equals(bTitle)) {
									break; // ������ ã������ ����������.
								}
							} // for 
							if(idx == books.length) { 
								System.out.println("�� ���������� �ش� ������ ã�� �� �����ϴ�.");
							
							} else {
								
								try { 
										books[idx].checkIn(); // 3. �ݳ� ó��
										
								} catch (Exception e) { 
										System.out.println(e.getMessage());
								
								}
							}  // if 
							break;
							
						default:
								System.out.println("0,1,2 �� ���ڸ� �Է��Ͻø� ����˴ϴ�.");
								// System.exit(0);
					} // switch
				
				} while (fn==0 || fn==1 || fn==2);
				sc.close();
		}
}


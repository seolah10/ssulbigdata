package com.lec.studentConsole;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMng {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentDao dao= StudentDao.getInstance();
		String fn;
		
		do {
			System.out.println("1:�Է� | 2:�а��� ��� | 3:��ü ��� | 4:�����л���� | �� ��:����");
			fn = scanner.next();
			
			switch(fn) {
			case "1":
				System.out.print("�̸�");
				String sname = scanner.next();
				System.out.print("�а�: ");
				String mname = scanner.next();
				System.out.print("����: ");
				int score = scanner.nextInt();
				if(score<0 || score>100) {
					System.out.println("��ȿ���� ���� �����Դϴ�.");
					continue;
				}
				int result = dao.insertStudent(sname, mname, score);
				System.out.println(result==StudentDao.SUCCESS ? "�Է¼���" : "�Է½���");
				break;
				
			case "2":
				System.out.print("�а� ��ȸ(�������� | �濵������ | ��ǻ�Ͱ��� | ����Ʈ���� | �ΰ�������): ");
				mname = scanner.next();
				
				ArrayList<StudentDto> students = dao.selectMname(mname);
				
				if(students.size()!=0) {
					System.out.println("���\t�̸�\t�а�\t����");
					for(StudentDto student : students) {
						System.out.println(student);
					}
				} else { 
					System.out.println("�ش� �а��� �л��� �����ϴ�.");
				}
				break;
				
			case "3":
				students = dao.selectStudent();
				if(students.size()!=0) {
					System.out.println("���\t�̸�\t�а�\t����");
					for(StudentDto student : students) {
						System.out.println(student);
					}
				} else { 
					System.out.println("�ش� �а��� �л��� �����ϴ�.");
				}
				break;
				
			case "4":
				students = dao.selectExpel();
				if(students.size()!=0) {
					System.out.println("���\t�̸�\t�а�\t����");
					for(StudentDto student : students) { 
						System.out.println(student);
					}
				} else {
					System.out.println("�ش� �а��� �л��� �����ϴ�.");
				}
				break;
			}
		} while(fn.equals("1")||fn.equals("2")||fn.equals("3")||fn.equals("4"));
		System.out.println("BYE!");
	}	
	
}

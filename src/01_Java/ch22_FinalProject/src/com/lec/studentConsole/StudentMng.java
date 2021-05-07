package com.lec.studentConsole;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMng {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentDao dao= StudentDao.getInstance();
		String fn;
		
		do {
			System.out.println("1:입력 | 2:학과별 출력 | 3:전체 출력 | 4:제적학생출력 | 그 외:종료");
			fn = scanner.next();
			
			switch(fn) {
			case "1":
				System.out.print("이름");
				String sname = scanner.next();
				System.out.print("학과: ");
				String mname = scanner.next();
				System.out.print("점수: ");
				int score = scanner.nextInt();
				if(score<0 || score>100) {
					System.out.println("유효하지 않은 점수입니다.");
					continue;
				}
				int result = dao.insertStudent(sname, mname, score);
				System.out.println(result==StudentDao.SUCCESS ? "입력성공" : "입력실패");
				break;
				
			case "2":
				System.out.print("학과 조회(빅데이터학 | 경영정보학 | 컴퓨터공학 | 소프트웨어 | 인공지능학): ");
				mname = scanner.next();
				
				ArrayList<StudentDto> students = dao.selectMname(mname);
				
				if(students.size()!=0) {
					System.out.println("등수\t이름\t학과\t점수");
					for(StudentDto student : students) {
						System.out.println(student);
					}
				} else { 
					System.out.println("해당 학과의 학생이 없습니다.");
				}
				break;
				
			case "3":
				students = dao.selectStudent();
				if(students.size()!=0) {
					System.out.println("등수\t이름\t학과\t점수");
					for(StudentDto student : students) {
						System.out.println(student);
					}
				} else { 
					System.out.println("해당 학과의 학생이 없습니다.");
				}
				break;
				
			case "4":
				students = dao.selectExpel();
				if(students.size()!=0) {
					System.out.println("등수\t이름\t학과\t점수");
					for(StudentDto student : students) { 
						System.out.println(student);
					}
				} else {
					System.out.println("해당 학과의 학생이 없습니다.");
				}
				break;
			}
		} while(fn.equals("1")||fn.equals("2")||fn.equals("3")||fn.equals("4"));
		System.out.println("BYE!");
	}	
	
}

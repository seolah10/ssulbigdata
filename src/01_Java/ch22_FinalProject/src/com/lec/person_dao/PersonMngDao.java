package com.lec.person_dao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonMngDao {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PersonDao dao = PersonDao.getInstance();
		String fn;
		ArrayList<PersonDto> person;
		
		do {
			System.out.println("1:입력 |2:직업별검색 | 3:전체출력 | 그 외:종료");
			fn = scanner.next();
			
			switch(fn) { 
			case "1": // 이름, 직업명, 국영수 입력받아 dao.insertPerson()호출
				System.out.println("이름: ");
				String name = scanner.next();
				System.out.println("직업: ");
				String jname = scanner.next();
				System.out.println("국어 점수: ");
				int kor = scanner.nextInt();
				System.out.println("영어 점수: ");
				int eng = scanner.nextInt();
				System.out.println("수학: ");
				int mat = scanner.nextInt();
				
				PersonDto newPerson = new PersonDto(name, jname, kor, eng, mat);
				int result = dao.insertPerson(newPerson); // 입력 완료
				System.out.println(result==PersonDao.SUCCESS ? "입력성공" : "입력실패");
				break;
			
			case "2": // 직업명 입력받아 dao.selectJname() 호출하여 결과 출력
				System.out.println("직업명 조회(배우|가수|엠씨): ");
				jname = scanner.next();
				person = dao.selectJname(jname);
				if(person.size()!=0) {
					System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
					for(PersonDto p : person) {
						System.out.println(p);
					}
				} else { 
					System.out.println("해당 직업을 가진 인원이 없습니다.");
				}
				break;
			
			case "3": // dao.selectAll() 호출하여 결과 출력
				person = dao.selectAll();
				if(person.size()!=0) {
					System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
					for(PersonDto p : person) {
						System.out.println(p);
					}
				} else { 
					System.out.println("해당 직업을 가진 인원이 없습니다.");
				}
				break;
			} // switch 
		} while(fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("DONE");
	}
}

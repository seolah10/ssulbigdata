package com.lec.person_dao;

import java.util.ArrayList;

public class PersonTestMain {
	public static void main(String[] args) {
		PersonDto dto = new PersonDto("��ȣ��", "����", 99, 99, 99);
		PersonDao dao = PersonDao.getInstance();
		int result = dao.insertPerson(dto);
		
		System.out.println(result==PersonDao.SUCCESS ? "�Է¼���" : "�Է½���");
		System.out.println("-----------2�� test------------");
		
		ArrayList<PersonDto> dtos = dao.selectJname("���");
		if(dtos.size()==0) {
			System.out.println("��츦 ã�� �� �����ϴ�.");
		} else { 
			for(PersonDto d : dtos) 
				System.out.println(d);
		}
		System.out.println("-----------3�� test------------");
		dtos = dao.selectAll();
		if(dtos.isEmpty()) { 
			System.out.println("��ϵ� ����� �����ϴ�.");
		} else {
			for(PersonDto d : dtos)
				System.out.println(d);
		}
	}
}

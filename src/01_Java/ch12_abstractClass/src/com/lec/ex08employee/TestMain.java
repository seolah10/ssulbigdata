package com.lec.ex08employee;

public class TestMain {
	
	public static void main(String[] args) {
		
		Employee[] employees = {
					new SalaryEmployee("������", 28000000),
					new SalaryEmployee("�����", 70000000),
					new SalaryEmployee("�ȵ���", 24000000),
					new HourlyEmployee("��ȣ��", 100, 8500),
					new HourlyEmployee("���¿�", 120, 9500) };
		
		for (Employee emp : employees) {
			System.out.println("~ ~ ~ ���� ���� ~ ~ ~");
			System.out.println("�� ��: "+emp.getName());
			System.out.println("�� ��: "+emp.computePay());
//			System.out.println("�� ��: "+temp.computeIncentive()); �Ұ���

			int incentive = emp.computeIncentive();
			
			if (incentive != 0) {
				System.out.println("�� ��: "+incentive);				
			}
			System.out.println("�� �� �� �� �� �� �� !");
		}		
		
	}

}

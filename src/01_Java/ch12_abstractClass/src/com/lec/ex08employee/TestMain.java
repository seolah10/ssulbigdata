package com.lec.ex08employee;

public class TestMain {
	
	public static void main(String[] args) {
		
		Employee[] employees = {
					new SalaryEmployee("박준형", 28000000),
					new SalaryEmployee("윤계상", 70000000),
					new SalaryEmployee("안데니", 24000000),
					new HourlyEmployee("손호영", 100, 8500),
					new HourlyEmployee("김태우", 120, 9500) };
		
		for (Employee emp : employees) {
			System.out.println("~ ~ ~ 월급 명세서 ~ ~ ~");
			System.out.println("성 함: "+emp.getName());
			System.out.println("월 급: "+emp.computePay());
//			System.out.println("상 여: "+temp.computeIncentive()); 불가능

			int incentive = emp.computeIncentive();
			
			if (incentive != 0) {
				System.out.println("상 여: "+incentive);				
			}
			System.out.println("수 고 하 셨 습 니 다 !");
		}		
		
	}

}

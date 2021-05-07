package com.lec.ex08employee;

public class SalaryEmployee extends Employee {

	private int annualSalary;
	
	
	public SalaryEmployee(String name, int annualSalary) {
		super(name);
		this.annualSalary = annualSalary;
	}


	@Override
	public int computePay() {
		return annualSalary / 14;
	}
	

}

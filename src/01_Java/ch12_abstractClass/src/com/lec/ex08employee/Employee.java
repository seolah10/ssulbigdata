package com.lec.ex08employee;

//Employee : name, computeIncentive(),computePay() 

public abstract class Employee {
	
	private String name;
	
	public Employee (String name) {
	 	this.name = name;
	 
	}
	
	 public abstract int computePay();
	 
	 public final int computeIncentive() {
		 int pay = computePay();
		 
		 if (pay > 2000000) {
			 return (int)(pay * 0.1);	
		 } //if 
		 return 0;
	 }	// computeIncentive

	 public String getName() {
			return name;
		} // getName 
	} // class 


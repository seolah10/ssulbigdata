package strategy3.modularization;

import strategy3.component.GetSalary;
import strategy3.component.JobLec;

public class Lecturer extends Person {

	private String subject;
	
	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());
	} 
	public void print() { //����������
			super.print();
			System.out.println("\t[����]"+subject);
	}
	public String toString() {
		 return super.toString()+"\t[����]"+subject;
	}
}

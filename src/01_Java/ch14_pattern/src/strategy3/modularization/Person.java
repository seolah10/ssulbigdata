package strategy3.modularization;

import strategy3.component.GetImpl;
import strategy3.component.JobImpl;

public class Person {
	
		private String id;
		private String name;
		private JobImpl job;
		private GetImpl get;
		
		public Person(String id, String name) {
			this.id = id;
			this.name = name; 
		}
		
		public void job() {
			job.job();
		}
		public void get() {
			get.get();
		}
		public void print() {
			System.out.print("[ID]"+id+"\t[�̸�]"+name);
		}
		@Override
		public String toString() {
			return "[ID]"+id+"\t[�̸�]"+name; 
		}
		
		public void setJob(JobImpl job) {
			this.job = job;
		}
		public void setGet(GetImpl get) {
			this.get = get;
		}
}

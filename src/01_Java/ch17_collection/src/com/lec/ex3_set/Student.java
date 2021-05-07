package com.lec.ex3_set;

//�̸�, �г� new Student("ȫ�浿",5);

public class Student {
	
		private String name;
		private int grade;
		
		public Student(String name, int grade) {
			this.name = name;
			this.grade = grade;
		}
		@Override
		public String toString() {
				return name+": "+grade;
		}
		@Override
		public boolean equals(Object obj) {
				
				if(this == obj) { 
						return true;
				}
				if(obj!=null && obj instanceof Student) {
						boolean nameChk = name.equals(((Student)obj).name);
						boolean gradeChk = name.equals(((Student)obj).grade);
						return nameChk && gradeChk;
//						return toString().equals(obj.toString());
				}
				return false;
		}
		@Override
		public int hashCode() {
				return toString().hashCode();
					// "�庸��:1"
		}
}

package com.lec.ex1_string;

//�̸�, ��ȭ��ȣ, ����(12-12) Friend f = new Friend("ȫ","8","12-12")
//print() : [�̸�]ȫ [��ȭ]8 [����]12-12

public class Friend {

		private String name;
		private String tel;
		private String birth;
		
		public Friend() {}

		public Friend(String name, String tel, String birth) {
			this.name = name;
			this.tel = tel;
			this.birth = birth;
		}
		// f.print() 
		public void print() {
			System.out.printf("[�̸�]%s [��ȭ]%s [����]%s\n",
								name, 	tel,	birth);
		}
		// System.out.println(f.toString())
		@Override
		public String toString() {
			return "[�̸�]"+name+"[��ȭ]"+tel+"[����]"+birth;
		}

		public String getName() {
			return name;
		}

		public String getTel() {
			return tel;
		}

		public String getBirth() {
			return birth;
		}
	
		
		
}

package com.lec.ex1_student;

public class StudentMain2 {
	public static void main(String[] args) {
//		Student s1 = new Student("���켺",90,90,90);
//		Student s2 = new Student("���ϴ�",81,90,90);
//		Student s3 = new Student("Ȳ����",91,90,90);
//		Student s4 = new Student("������",80,90,90);
//		Student s5 = new Student("������",70,90,90);
		
		Student[] student = {new Student("���켺",90,90,90),
							 new Student("���ϴ�",81,90,90),
							 new Student("Ȳ����",90,90,90),
							 new Student("������",80,90,90),
							 new Student("������",70,90,90)};
		String[] title = {"�̸�","����","����","����","���","����"};
		
		// �� ���� �������� ����(0:�����, 1:�����, 2:���д���, 3:��������, 4:��մ���)
		// �迭 tot�� avg�� 0�̳� 0.0���� �ʱ�ȭ
		
		int[] tot = new int[5];
		double[] avg = new double[5]; // �� ���� ����, ��� ����
		
		System.out.println("\t"
				+ "�����������������������������������������������������");
		System.out.println("\t\t\t\t����ǥ");
		System.out.println("\t-------------------------------------------------");

		for(String t : title) { 
			System.out.print("\t"+t);
		}
		System.out.println();
		System.out.println("\t-------------------------------------------------");
		
		for(Student s : student) {
			s.print();
			
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMat();
			tot[3] += s.getTot();
			tot[4] += s.getAvg();
		}
		System.out.println("\t-------------------------------------------------");
		System.out.print("\t����");


//			for(int idx=0; idx<=avg.length ; idx++) { // ��յ� ���
//			avg[idx] = tot[idx] / student.length;
//			}	
		for(int idx=0; idx<=avg.length ; idx++) {
				avg[idx] = tot[idx] / student.length;
				System.out.print("\t "+tot[idx]);
		}
		System.out.print("\n\t���");
		
		for(double a : avg) {
			System.out.print("\t"+a);
			
		}
		System.out.println();
		System.out.println(
				"�����������������������������������������������������");

	}
}





























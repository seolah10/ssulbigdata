package com.lec.ex7_static_student;

// ����ǥ �����  <����� ����>

public class StudentTestMain {
	public static void main(String[] args) {
		
		StudentTest[] student = { new StudentTest("���켺", 90, 80, 95),
								  new StudentTest("���ϴ�",100, 80, 95),
								  new StudentTest("Ȳ����", 95, 80, 90),
								  new StudentTest("������", 95, 90, 99),
								  new StudentTest("������", 90, 90, 90) };
		int tot[] = new int[5];
		int avg[] = new int[tot.length];
		
			System.out.println("������������������������������������������������������������������������");
			System.out.println("\t\t\t\t����ǥ");
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("��ȣ"+"\t�̸�"+"\t����"+"\t����"+"\t����"+"\t���");
			System.out.println("-----------------------------------------------------------------------");			
			
			for(StudentTest s : student) { 
					System.out.println(s.infoString());
					
					tot[0] += s.getKor();
					tot[1] += s.getEng();
					tot[2] += s.getMat();
					tot[3] += s.getTot();
					tot[4] += s.getAvg();
			}
			System.out.println("-----------------------------------------------------------------------");			

			for(int idx=0 ; idx < avg.length ; idx++) {
				avg[idx] = tot[idx] / student.length; // ����
				avg[idx] = (int) ((double)tot[idx] / student.length + 0.5); //�ݿø�
			}
			System.out.print("����"+"\t\t");
			for (int t: tot) { 
					System.out.print(t+"\t");
			}
			System.out.println();
			
			System.out.print("���"+"\t\t");
			for (int a : avg) {
					System.out.print(a+"\t");
			}
			System.out.println();
			System.out.println("������������������������������������������������������������������������");
	}
}

















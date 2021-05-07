package com.lec.ex7_static_student;

// 성적표 만들기  <제출용 과제>

public class StudentTestMain {
	public static void main(String[] args) {
		
		StudentTest[] student = { new StudentTest("정우성", 90, 80, 95),
								  new StudentTest("김하늘",100, 80, 95),
								  new StudentTest("황정민", 95, 80, 90),
								  new StudentTest("강동원", 95, 90, 99),
								  new StudentTest("유아인", 90, 90, 90) };
		int tot[] = new int[5];
		int avg[] = new int[tot.length];
		
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("\t\t\t\t성적표");
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("번호"+"\t이름"+"\t국어"+"\t수학"+"\t총점"+"\t평균");
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
				avg[idx] = tot[idx] / student.length; // 버림
				avg[idx] = (int) ((double)tot[idx] / student.length + 0.5); //반올림
			}
			System.out.print("총점"+"\t\t");
			for (int t: tot) { 
					System.out.print(t+"\t");
			}
			System.out.println();
			
			System.out.print("평균"+"\t\t");
			for (int a : avg) {
					System.out.print(a+"\t");
			}
			System.out.println();
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
}

















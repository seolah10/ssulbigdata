package strategy3.modularization;

public class TestMain {

		public static void main(String[] args) {
			
			Student st1 = new Student ("30301", "송민호", "python반");
			Student st2 = new Student("30302", "표지훈", "Java반");
			Lecturer gs1 = new Lecturer("J01", "강호동", "hadoop반");
			Lecturer gs2 = new Lecturer("J02", "이수근", "Database반");
			Staff s1 = new Staff ("A01", "은지원", "취업지원");
			Staff s2 = new Staff ("A02", "조규현", "수강상담");
					
			Person[] person = {st1, st2, gs1, gs2, s1, s2};
			
			System.out.println("== 업무시간이니 열심히 일합시다.");
			for(Person p : person) {
				p.job();
			}
			System.out.println("== 월말엔 다 지급할 것들 지급");
			for(Person p : person) {
				p.get();
			}
			for(Person p : person) {
				p.print();
//				System.out.println(p);
			}
		}
		
}

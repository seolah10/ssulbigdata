package strategy3.modularization;

public class TestMain {

		public static void main(String[] args) {
			
			Student st1 = new Student ("30301", "�۹�ȣ", "python��");
			Student st2 = new Student("30302", "ǥ����", "Java��");
			Lecturer gs1 = new Lecturer("J01", "��ȣ��", "hadoop��");
			Lecturer gs2 = new Lecturer("J02", "�̼���", "Database��");
			Staff s1 = new Staff ("A01", "������", "�������");
			Staff s2 = new Staff ("A02", "������", "�������");
					
			Person[] person = {st1, st2, gs1, gs2, s1, s2};
			
			System.out.println("== �����ð��̴� ������ ���սô�.");
			for(Person p : person) {
				p.job();
			}
			System.out.println("== ������ �� ������ �͵� ����");
			for(Person p : person) {
				p.get();
			}
			for(Person p : person) {
				p.print();
//				System.out.println(p);
			}
		}
		
}

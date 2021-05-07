package singleton.step1;

public class TestMain {
		
		public static void main(String[] args) {
			
			SingletonClass obj1 = SingletonClass.getInstance();
			SingletonClass obj2 = SingletonClass.getInstance();
			
			System.out.println("�ʱ�ȭ�� i��: "+obj1.getI());
			
			obj1.setI(999);
			System.out.println("obj1�� i���� ������ �� obj2�� ��: "+obj2.getI());
			System.out.println("=====================");
			
			AClass a1 = AClass.getInstance();
			a1.setIntVar(999);
			
			AClass a2 = AClass.getInstance();
			System.out.println(a2.getIntVar());
			
		}
}

// Singleton Pattern�� ��ü�� �޶� �ϳ��� ���� ����س���.(?)
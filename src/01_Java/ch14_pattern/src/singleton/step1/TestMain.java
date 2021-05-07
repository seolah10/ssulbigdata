package singleton.step1;

public class TestMain {
		
		public static void main(String[] args) {
			
			SingletonClass obj1 = SingletonClass.getInstance();
			SingletonClass obj2 = SingletonClass.getInstance();
			
			System.out.println("초기화된 i값: "+obj1.getI());
			
			obj1.setI(999);
			System.out.println("obj1의 i값을 변경한 후 obj2의 값: "+obj2.getI());
			System.out.println("=====================");
			
			AClass a1 = AClass.getInstance();
			a1.setIntVar(999);
			
			AClass a2 = AClass.getInstance();
			System.out.println(a2.getIntVar());
			
		}
}

// Singleton Pattern은 객체가 달라도 하나의 값만 출력해낸다.(?)
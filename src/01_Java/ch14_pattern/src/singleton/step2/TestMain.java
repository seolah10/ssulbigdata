package singleton.step2;

public class TestMain {
	
		public static void main(String[] args) {
			
			FirstClass obj1 = new FirstClass();
			SecondClass obj2 = new SecondClass();
			SingletonClass singleObj = SingletonClass.getInstance();
			
			System.out.println("Main Method���� singleObj�� ���� ");
			System.out.println(singleObj.getI());
					
		}

}

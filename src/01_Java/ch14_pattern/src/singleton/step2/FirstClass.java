package singleton.step2;

public class FirstClass {

		public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		
		System.out.println("FirstClass�� ��ü ����");
		System.out.println(singletonObject.getI());
		
		singletonObject.setI(777);
		System.out.println("���� �� i��(FirstClass����)"+singletonObject.getI());
		
		System.out.println("FirstClass�� ������ ��");
		}	
}

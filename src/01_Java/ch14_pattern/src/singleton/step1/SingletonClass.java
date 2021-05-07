package singleton.step1;

public class SingletonClass {

	private int i;
	
	private static SingletonClass INSTANCE; // SingletonClass형 객체주소

	public static SingletonClass getInstance() {
			if(INSTANCE==null) {
				INSTANCE = new SingletonClass();
			}
			return INSTANCE;
	}
	private SingletonClass() {
		i = 10;
	}
	
	public int getI() {
		return i;
		}
	public void setI(int i) {
		this.i = i;
	}
}


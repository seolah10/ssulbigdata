
public class EqualsFunction {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		if(i == j) {
			System.out.println("���� ����.");
		}
		String cardNo1 = "9999-9999-9999-9999";
		String cardNo2 = "9999-9999-9999-9999";
		if(cardNo1.equals(cardNo2)) {
			System.out.println("���� ����.");
		}
	}
}

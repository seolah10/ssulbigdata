import java.util.Scanner;

public class ExScanner {

		public static void main(String[] args) {
			
				// �̸�, ����, ���̸� �Է� 
				Scanner sc = new Scanner(System.in);
				
				System.out.print("�̸��� �Է��ϼ���: ");
				String name = sc.next();
				System.out.println("�Է��� �̸��� "+name);
				
				nickName();
				
				System.out.print("���̸� �Է��ϼ���: ");
				int age = sc.nextInt();
				System.out.println("�Է��� ���̴� "+age);
				
				sc.close();
		}
		private static void nickName() {
				
				Scanner sc = new Scanner(System.in);
				
				System.out.print("������ �Է��ϼ���");
				String nickName = sc.next();
				System.out.println("������ "+nickName);
		}
}

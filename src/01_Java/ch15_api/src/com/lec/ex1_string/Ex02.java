package com.lec.ex1_string;

public class Ex02 {
	
	 	public static void main(String[] args) {
			
	 		String str1 = "abcXabc";
	 		String str2 = new String("ABCXabc");
	 		String str3 = "		ja	va	";
	 		
	 		System.out.println("1. "+str1.concat(str2)); // �� ���ڸ� �ٿ� ����
	 		System.out.println("2. "+str1.substring(3)); // 3�� �ε������� ������
	 		System.out.println("3. "+str1.substring(3,5)); // 3�� �ε������� 5�� �� �ε�������
	 		System.out.println("4. "+str1.length()); //������ ����
	 		System.out.println("5. "+str1.toUpperCase()); // �빮�ڷ� ��ȯ
	 		System.out.println("6. "+str1.toLowerCase()); // �ҹ��ڷ� ��ȯ
	 		System.out.println("7. "+str1.charAt(3)); // 3�� �ε��� ���� �ϳ� ���
	 		System.out.println("8. "+str1.indexOf("b")); // ���� 'b'�� �ε��� ��ȣ(�ߺ��� ���, �� �ε����� ������)
	 		System.out.println("9. "+str1.indexOf("b",3)); // 3�� �ε��� �������� �� �ڿ��� ������ ���� 'b'�� �ε��� ��ȣ
	 		System.out.println("10. "+str1.lastIndexOf("b")); // ���� �������� ������ ���� 'b'�� �ε��� ��ȣ
	 		System.out.println("11. "+str1.indexOf("z")); // �ش� ������ ���� ���ڸ� �Է��� ���, -1�� ��µȴ�.
	 		System.out.println("12. "+str1.equals(str2)); // �� ���ڰ� ������ true, �ٸ��� false ���
	 		System.out.println("13. "+str1.equalsIgnoreCase(str2));
	 		System.out.println("14. "+str3.trim()); // �¿� space ����
	 		System.out.println("15. "+str1.replace('a', 'j')); // ���� ���� ��� ���� ���ڷ� ���� (�ߺ��Ǵ� ���ڵ鵵 ��)
	 		System.out.println("16. "+str1.replace("ab", "�ٲ�"));
	 		System.out.println("���� str1: "+str1);
	 	}

}

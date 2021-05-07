package com.lec.ex1_string;

public class Ex09_stringBuffer {
	
	public static void main(String[] args) {
		
			String str = new String("abc");
			StringBuilder strBu = new StringBuilder("abc");
			
			System.out.println("1. "+strBu);
			
			strBu.append("def"); // �ش繮�� �ڿ� �߰�
			System.out.println("2. "+strBu);
			
			strBu.insert(3, "AAA"); // 3�� �ε����� "AAA"�߰�
			System.out.println("3. "+strBu);
			
			strBu.delete(3, 6); // 3�� ���� 6�� �� �ε������� ����
			System.out.println("4. "+strBu);
			
			
			int capacitySize = strBu.capacity(); // <���� ũ��>
			
			System.out.println("����ũ��: "+capacitySize);
			System.out.println("�� strBu�� �ؽ��ڵ�: "+strBu.hashCode());
 			
			strBu.append("12345678901234567890");
			capacitySize = strBu.capacity();
			System.out.println("����ũ�� ����: "+capacitySize);
			System.out.println("���� �� strBu�� �ؽ��ڵ�: "+strBu.hashCode());
	
			// ����ũ�⸦ ���������� �ø���
			strBu.ensureCapacity(1000);
			capacitySize = strBu.capacity();
			System.out.println("����ũ�� ����: "+capacitySize);
			System.out.println("���� �� strBu�� �ؽ��ڵ�: "+strBu.hashCode() );
	}

}
















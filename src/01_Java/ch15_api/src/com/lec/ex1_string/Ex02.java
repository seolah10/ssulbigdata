package com.lec.ex1_string;

public class Ex02 {
	
	 	public static void main(String[] args) {
			
	 		String str1 = "abcXabc";
	 		String str2 = new String("ABCXabc");
	 		String str3 = "		ja	va	";
	 		
	 		System.out.println("1. "+str1.concat(str2)); // 두 문자를 붙여 연결
	 		System.out.println("2. "+str1.substring(3)); // 3번 인덱스부터 끝까지
	 		System.out.println("3. "+str1.substring(3,5)); // 3번 인덱스부터 5번 앞 인덱스까지
	 		System.out.println("4. "+str1.length()); //문자의 길이
	 		System.out.println("5. "+str1.toUpperCase()); // 대문자로 변환
	 		System.out.println("6. "+str1.toLowerCase()); // 소문자로 변환
	 		System.out.println("7. "+str1.charAt(3)); // 3번 인덱스 문자 하나 출력
	 		System.out.println("8. "+str1.indexOf("b")); // 문자 'b'의 인덱스 번호(중복될 경우, 앞 인덱스의 것으로)
	 		System.out.println("9. "+str1.indexOf("b",3)); // 3번 인덱스 기준으로 그 뒤에서 나오는 문자 'b'의 인덱스 번호
	 		System.out.println("10. "+str1.lastIndexOf("b")); // 가장 마지막에 나오는 문자 'b'의 인덱스 번호
	 		System.out.println("11. "+str1.indexOf("z")); // 해당 변수에 없는 문자를 입력할 경우, -1이 출력된다.
	 		System.out.println("12. "+str1.equals(str2)); // 두 문자가 같으면 true, 다르면 false 출력
	 		System.out.println("13. "+str1.equalsIgnoreCase(str2));
	 		System.out.println("14. "+str3.trim()); // 좌우 space 제거
	 		System.out.println("15. "+str1.replace('a', 'j')); // 앞의 문자 대신 뒤의 문자로 변경 (중복되는 문자들도 다)
	 		System.out.println("16. "+str1.replace("ab", "바꿔"));
	 		System.out.println("최종 str1: "+str1);
	 	}

}

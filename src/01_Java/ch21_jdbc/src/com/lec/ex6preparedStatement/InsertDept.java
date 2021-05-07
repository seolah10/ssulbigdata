package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("부서 번호: ");
		int deptno = scanner.nextInt();
		System.out.println("부서 이름: ");
		String dname = scanner.next();
		System.out.println("부서 위치: ");
		scanner.nextLine(); // \n이 있는 버퍼 clear
		String loc = scanner.nextLine(); 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
				
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
			//int result = pstmt.executeUpdate(sql);
			int result = pstmt.executeUpdate();
			System.out.println(result>0 ? "부서 입력 성공" : "부서 입력 실패");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { 
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

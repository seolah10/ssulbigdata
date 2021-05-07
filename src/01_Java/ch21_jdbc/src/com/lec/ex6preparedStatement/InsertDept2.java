package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("추가할 부서 번호: ");
		int deptno = scanner.nextInt();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		String SelectSql = "SELECT * FROM DEPT WHERE DEPTNO=?";
		String InsertSql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(SelectSql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery(); 
			
			if(!rs.next()) {
				System.out.println("부서 이름: ");
				String dname = scanner.next();
				System.out.println("부서 위치: ");
				scanner.nextLine(); 
				String loc = scanner.nextLine(); 
				rs.close();
				pstmt.close();
				
				pstmt = conn.prepareStatement(InsertSql);
				pstmt.setInt(1, deptno);
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);
				
				int result = pstmt.executeUpdate();
				System.out.println(result>0 ? "추가 성공" : "추가 실패");
				
				if(result>0) {
					System.out.println("입력 성공");
				}
			} else { 
				System.out.println("중복된 부서 번호입니다.");				
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { 
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

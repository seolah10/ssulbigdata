package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class lnsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("부서 번호: ");
		int deptno = scanner.nextInt();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		String sql = "SELECT * FROM DEPT WHERE DEPTNO= " + deptno;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); 
			
			if(rs.next()) {
				System.out.println("중복된 부서 번호입니다.");
			} else { 
				System.out.println("부서 이름: ");
				String dname = scanner.next();
				System.out.println("부서 위치: ");
				scanner.nextLine(); 
				String loc = scanner.nextLine(); 
				
				String sql2 = String.format(
						"INSERT INTO DEPT VALUES(%d, %s, %s)", deptno, dname, loc);
				int result = stmt.executeUpdate(sql2);
				if(result>0) {
					System.out.println("입력 성공");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { 
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

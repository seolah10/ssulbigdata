
package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDeptno {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null; 
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("부서 번호: ");
		int deptno = scanner.nextInt();
		String sql = "SELECT * FROM DEPT WHERE DEPTNO = " + deptno; 
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				System.out.println(deptno + "번 부서의 정보입니다.");
				System.out.println("부서명: " + dname);
				System.out.println("위 치: " + loc);
			} else {
				System.out.println("존재하지 않는 부서입니다.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				
			}
		}
	}
}

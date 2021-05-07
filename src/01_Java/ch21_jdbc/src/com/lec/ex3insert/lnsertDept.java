package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class lnsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("�μ� ��ȣ: ");
		int deptno = scanner.nextInt();
		System.out.println("�μ� �̸�: ");
		String dname = scanner.next();
		System.out.println("�μ� ��ġ: ");
		scanner.nextLine(); // \n�� �ִ� ���� clear
		String loc = scanner.nextLine(); 
		
		Connection conn = null;
		Statement stmt = null;
		String sql = "INSERT INTO DEPT VALUES (" + deptno + ",'" + dname + "','" + loc + "')";
		sql = String.format("INSERT INTO DEPT VALUES (%d,'%s','%s')", deptno, dname, loc);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0 ? "�μ� �Է� ����" : "�μ� �Է� ����");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { 
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

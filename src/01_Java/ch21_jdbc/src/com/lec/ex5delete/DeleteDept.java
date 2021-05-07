package com.lec.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������ �μ� ��ȣ: ");
		int deptno = scanner.nextInt();
		
		Connection conn = null;
		Statement stmt = null;
		String deleteSql = "DELETE FROM DEPT WHERE DEPTNO = " + deptno;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(deleteSql);
			
			if(result > 0) {
				System.out.println("���� �Ϸ�");
			}else {
				System.out.println("�������� �ʴ� �μ� ��ȣ�Դϴ�.");
			}
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			} 
		}
	}
}

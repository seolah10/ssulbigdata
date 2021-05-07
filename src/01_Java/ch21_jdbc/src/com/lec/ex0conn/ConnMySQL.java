package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver"; // 8.0
		String url = "jdbc:mysql://localhost:3306/park?serverTimezone=UTC";
		Connection conn = null;
		
		try {
			// 1. ����̹� �ε�
			Class.forName(driver);
			System.out.println("����̹� �ε� ����");
			// 2. DB���� ��ü 
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("MYSQL DB���� ����");
		}catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(conn!=null) conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver"; 
		String url = "jdbc:mysql://localhost:3306/park?serverTimezone=UTC";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM PERSONAL";
		
		try {
			Class.forName(driver); // (1) ����̹� �ε�
			conn = DriverManager.getConnection(url, "root", "mysql"); // (2) DB ����
			stmt = conn.createStatement(); // (3) SQL���� ��ü ����
			rs = stmt.executeQuery(query); // (4) SQL���� + (5) SQL ���� ��� �ޱ�
			// (6) ��� �޾Ƽ� ���ϴ� ���� ���� - rs�� �ִ� ������ �ֿܼ� ���
			System.out.println(
					"���\t�̸�\t��å\t\t�����\t�Ի���\t�޿�\t�󿩱�\t�μ���ȣ");
			if(rs.next()) {
				do {
		
					int pno = rs.getInt("pno");
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					int manager = rs.getInt("manager");
					Timestamp startdate = rs.getTimestamp("startdate");
					//Date hiredate = rs.getDate("hiredate");
					//String hiredate = rs.getString("hiredate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
						
					if(pname!=null && pname.length()<7) {
						System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n",
								pno, pname, job, manager, startdate, pay, bonus, dno);
					} else {
						System.out.printf("%d\t %s %s\t %d\t %TF\t %d\t %d\t %d\n",
								pno, pname, job, manager, startdate, pay, bonus, dno);
					} 
				} while(rs.next());
			} else {
				System.out.println("��� ������ �����ϴ�. ");
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
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}				
		}
	}
}

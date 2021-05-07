package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������ �μ� ��ȣ: ");
		String deptno = scanner.next();		
		
		String selectQuery = "SELECT * FROM DEPT WHERE DEPTNO= " + deptno;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
				
		try { 
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);
			
			if (rs.next()) {
				System.out.println("������ �μ���: ");
				String dname = scanner.next();
				System.out.println("������ �μ� ��ġ: ");
				String loc = scanner.next();
				
				String query = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s'" + 
						"WHERE DEPTNO=%s", dname, loc, deptno);
				int result = stmt.executeUpdate(query);
				System.out.println(result>0 ? "�μ� ���� ����" : "�μ� ���� ���� ");
			} else { 
				System.out.println("��ȿ���� ���� ��ȣ�̹Ƿ� ������ �����մϴ�.");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("���� ����");
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

package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������ �μ� ��ȣ: ");
		int deptno = scanner.nextInt();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO=?";
		
		try { 
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("������ �μ���: ");
				String dname = scanner.next();
				System.out.println("������ �μ� ��ġ: ");
				String loc = scanner.next();
				rs.close();
				pstmt.close();
				
				String sql2 = "UPDATE DEPT SET DNAME=?, LOC=?, WHERE DEPTNO=?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				
				int result = pstmt.executeUpdate();
				System.out.println(result>0 ? "�μ� ���� ����" : "���� �μ� ��ȣ");
			}else {
				System.out.println("�������� �ʴ� �μ��Դϴ�.");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("���� ����");
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

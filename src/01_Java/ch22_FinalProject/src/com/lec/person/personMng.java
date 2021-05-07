package com.lec.person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class personMng {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		
		String fn;
		
		try {
			Class.forName(driver); // 1�ܰ�� ó�� �ѹ���
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		do {
			System.out.print("1:�Է� | 2:��������� | 3.��ü��� | �� ��: ����");
			fn = scanner.next();
			
			switch(fn) {
			
			case "1": 
				System.out.print("�̸�: ");
				String name = scanner.next();
				System.out.print("����(���|����|����): ");
				String jname = scanner.next();
				System.out.print("����: ");
				int kor = scanner.nextInt();
				System.out.print("����: ");
				int eng = scanner.nextInt();
				System.out.print("����: ");
				int mat = scanner.nextInt();
				
				String sql1= "INSERT INTO PERSON VALUES " +
							 " (PERSON_NO_SQ.NEXTVAL, ?," +
							 " (SELECT JNO FROM JOB WHERE JNAME=?), ?, ?, ?)";
				
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql1);
					pstmt.setString(1, name);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					
					int result = pstmt.executeUpdate();
					System.out.println(result>0 ? "�Է� ����" : "�Է� ����");
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
						
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
					}
				}
				break; 
			case "2": // �������� �Է¹޾� ������ ��� (select)
				System.out.println("������(���|����|����): ");
				jname = scanner.next();
				String sql2 = "SELECT ROWNUM RANK, S.*" +
								" FROM (SELECT NAME||'('||NO||')��' NAME, JNAME, KOR, ENG, MAT," +
								" KOR+ENG+MAT SUM " +
								" FROM PERSON P, JOB J" +
								" WHERE P.JNO=J.JNO AND JNAME=?" +
								" ORDER BY SUM DESC) S";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, jname);
					
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
						
						do {
							int rank = rs.getInt("rank");
							name = rs.getString("name");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							
							System.out.println(rank + "\t" + name + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" +sum);
						} while (rs.next());
					} else {
						System.out.println("�ش� ������ �ش��ϴ� ����� ã�� �� �����ϴ�.");
					}
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
	
				} finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
						
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
					}
				}
				break; 
			
			case "3": // ��ü ��� (select) 
				String sql3 = "SELECT ROWNUM RANK, S.* " + 
						"    FROM (SELECT NAME||'('||NO||'��)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
						"            FROM PERSON P, JOB J" + 
						"            WHERE P.JNO = J.JNO" + 
						"            ORDER BY SUM DESC) S";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql3);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
						
						do {
							int rank = rs.getInt("rank");
							name = rs.getString("name");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							
							System.out.println(rank + "\t" + name + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" +sum);
						} while (rs.next());
					} else {
						System.out.println("�ش� ������ �ش��ϴ� ����� ã�� �� �����ϴ�.");
					}
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
	
				} finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
						
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
					}
				}
				break; 
			}
		} while(fn.equals("1") || fn.equals("2" ) || fn.equals("3"));
		System.out.println("BYE");
	}
}

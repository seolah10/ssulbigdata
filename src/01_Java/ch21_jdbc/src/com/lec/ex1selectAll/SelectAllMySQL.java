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
			Class.forName(driver); // (1) 드라이버 로드
			conn = DriverManager.getConnection(url, "root", "mysql"); // (2) DB 연결
			stmt = conn.createStatement(); // (3) SQL전송 객체 생성
			rs = stmt.executeQuery(query); // (4) SQL전송 + (5) SQL 전송 결과 받기
			// (6) 결과 받아서 원하는 로직 수행 - rs에 있는 데이터 콘솔에 출력
			System.out.println(
					"사번\t이름\t직책\t\t상사사번\t입사일\t급여\t상여금\t부서번호");
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
				System.out.println("사원 정보가 없습니다. ");
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

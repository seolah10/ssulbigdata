package com.lec.person_dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class PersonDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static PersonDao INSTANCE;
	
	public static PersonDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new PersonDao();
		}
		return INSTANCE;
	}
	private PersonDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1. insertPerson(PersonDto dto) 
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON VALUES " + 
							"	(PERSON_NO_SQ.NEXTVAL, ?," + 
							"		(SELECT JNO FROM JOB WHERE JNAME=?),?,?,?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 2. ������ �˻� 
	public ArrayList<PersonDto> selectJname(String jname) {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// jname ������ ����� ����Ʈ dtos�� add�ϱ�
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		String sql = "SELECT ROWNUM RANK, S.*" + 
				"    FROM (SELECT NAME||'('||NO||'��)' NAME, JNAME, KOR, ENG, MAT," + 
				"        KOR+ENG+MAT SUM " + 
				"    FROM PERSON P, JOB J" + 
				"    WHERE P.JNO=J.JNO AND JNAME=?" + 
				"    ORDER BY SUM DESC) S";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				
				dtos.add(new PersonDto(rank, name, jname, kor, eng, mat, sum));
			}			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 3. ��ü ��� 
	public ArrayList<PersonDto> selectAll() {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// jname ������ ����� ����Ʈ dtos�� add�ϱ�
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		String sql = "SELECT ROWNUM RANK, S.*" + 
				"    FROM (SELECT NAME||'('||NO||'��)' NAME, JNAME, KOR, ENG, MAT," + 
				"        KOR+ENG+MAT SUM " + 
				"    FROM PERSON P, JOB J" + 
				"    WHERE P.JNO=J.JNO " + 
				"    ORDER BY SUM DESC) S";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String name = rs.getString("name");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				
				dtos.add(new PersonDto(rank, name, jname, kor, eng, mat, sum));
			}			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	public Vector<String> jnamelist() {
		Vector<String> jnames = new Vector<String>();
		jnames.add("");
		// ���� ����Ʈ�� jname�� add�ϱ�
		
		String sql = "SELECT JNAME FROM JOB";
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
			}			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return jnames;
	}
}

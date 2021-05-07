package com.lec.studentConsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0; 
	private static StudentDao INSTANCE; 
	
	public static StudentDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new StudentDao();	
		}
		return INSTANCE;
	}
	public StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	public int insertStudent(String sname, String mname, int score) {
		int result = FAIL;
		Connection  conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE) " + 
				"    VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL,'000'))," + 
				"            ?, (SELECT MNO FROM MAJOR WHERE MNAME=?), ?)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			pstmt.setString(2, mname);
			pstmt.setInt(3, score);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(pstmt!=null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public ArrayList<StudentDto> selectMname(String mname) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ROWNUM RANK, SNO, SNAME, MNAME, SCORE" + 
				"    FROM (SELECT * FROM STUDENT S, MAJOR M" + 
				"            WHERE S.MNO=M.MNO AND MNAME=?" + 
				"            ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				int score = rs.getInt("score");
				
				dtos.add(new StudentDto(rank, sno, sname, mname, score));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt!=null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	public ArrayList<StudentDto> selectStudent() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ROWNUM RANK, SNO, SNAME, MNAME, SCORE" + 
				"    FROM (SELECT * FROM STUDENT S, MAJOR M  " + 
				"            WHERE S.MNO = M.MNO AND EXPEL=0" + 
				"            ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				
				dtos.add(new StudentDto(rank, sno, sname, mname, score));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt!=null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	public ArrayList<StudentDto> selectExpel() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		
		String sql = "SELECT ROWNUM RANK, SNO, SNAME, MNAME, SCORE" + 
				"    FROM (SELECT * FROM STUDENT S, MAJOR M  " + 
				"            WHERE S.MNO = M.MNO AND EXPEL=1" + 
				"            ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				
				dtos.add(new StudentDto(rank, sno, sname, mname, score));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt!=null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
}

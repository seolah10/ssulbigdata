package com.lec.StudentGUI;
/*
0. ùȭ�鿡 �����̸��� �޺��ڽ��� �߰�(mName) 
	: public Vector<String> getMNamelist()
1. �й��˻� (sNo, sName, mName, score) 
	: public StudentSwingDto sNogetStudent(String sNo)
2. �̸��˻� (sNo, sName, mName, score) 
	: public ArrayList<StudentSwingDto> sNamegetStudent(String sName)
3. �����˻� (rank, sName(sNo����), mName(mNo����), score) 
	: public ArrayList<StudentSwingDto> mNamegetStudent(String mName)
4. �л��Է� 
	: public int insertStudent(String sName, String mName, int score)
    public int insertStudent(StudentSwingDto dto)
5. �л����� 
	: public int updateStudent(String sNo,String sName,
															String mName,int score)
    public int updateStudent(StudentSwingDto dto)
6. �л���� (rank, sName(sNo����), mName(mNo����), score) 
	: public ArrayList<StudentSwingDto> getStudents()
7. ���������  (rank, sName(sNo����), mName(mNo����), score) 
	: public ArrayList<StudentSwingDto> getStudentsExpel()
8. ����ó�� : public int sNoExpel(String sNo)
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class StudentSwingDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static StudentSwingDao INSTANCE;
	public static StudentSwingDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new StudentSwingDao();
		}
		return INSTANCE;
	}
	public StudentSwingDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 0. ùȭ��: �����̸� �޺��ڽ��� �߰� �� 
	public Vector<String> getNamelist() {
		Vector<String> mnames = new Vector<String>();
		mnames.add("");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		String sql = "SELECT MNAME FROM MAJOR";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				mnames.add(rs.getString("mname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return mnames;
	}
	// 1. �й� �˻� 
	public StudentSwingDto sNoGetStudent(String sno) {
		StudentSwingDto dto = null; 
		Connection conn  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE " + 
				"    FROM STUDENT S, MAJOR M" + 
				"    WHERE S.MNO=M.MNO AND SNO=?";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			rs = pstmt.executeQuery(sql);
			
			if(rs.next()) {
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				
				dto = new StudentSwingDto(sno, sname, mname, score);
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
		return dto; 
	}
	// 2. �̸��˻� 
	public ArrayList<StudentSwingDto> snameGetStudent(String sname) {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection         conn  = null;
		PreparedStatement  pstmt = null;
		ResultSet          rs    = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE " + 
				"    FROM STUDENT S, MAJOR M" + 
				"    WHERE S.MNO=M.MNO AND SNAME=?";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String sno = rs.getString("sno");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				
				dtos.add(new StudentSwingDto(sno, sname, mname, score));
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
	// 3. �����˻� 
	public ArrayList<StudentSwingDto> mnameGetStudent(String mname) {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection         conn  = null;
		PreparedStatement  pstmt = null;
		ResultSet          rs    = null;
		String sql = "SELECT ROWNUM RANK, SNAME||'('||SNO||')' SNAME, MNAME||'('||MNO||')' MNAME, SCORE" + 
				"    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M" + 
				"            WHERE S.MNO=M.MNO AND MNAME=?" + 
				"            ORDER BY SCORE DESC)";

		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sname = rs.getString("sname");
				mname = rs.getString("mname"); // �Ķ���ͷ� �Էµ� mName�� �������� ��� ���⼭�� mName�� ������(1)
				int score = rs.getInt("score");
				
				dtos.add(new StudentSwingDto(rank, sname, mname, score));
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
	// 4. �л��Է� 
	public int insertStudent(String sname, String mname, int score) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE) " + 
				"    VALUES (TO_CHAR(SYSDATE, 'YYYY') || TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000'))," + 
				"    ?, (SELECT MNO FROM MAJOR WHERE MNAME=?), ?)";
		
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
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public int insertStudent(StudentSwingDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE) " + 
				"    VALUES (TO_CHAR(SYSDATE, 'YYYY') || TRIM(TO_CHAR(STUDENT_SEQ.NEXTVAL, '000'))," + 
				"    ?, (SELECT MNO FROM MAJOR WHERE MNAME=?), ?)";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());
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
	// 5. �л� ���� 
	public int updateStudent(String sno, String sname, String mname, int score) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET SNAME=?," + 
				"    MNO=(SELECT MNO FROM MAJOR WHERE MNAME=?)," + 
				"    SCORE=?" + 
				"        WHERE SNO=?";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			pstmt.setString(2, mname);
			pstmt.setInt(3, score);
			pstmt.setString(4, sno);
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
	public int updateStudent(StudentSwingDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET SNAME=?," + 
				"    MNO=(SELECT MNO FROM MAJOR WHERE MNAME=?)," + 
				"    SCORE=?" + 
				"        WHERE SNO=?";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());
			pstmt.setString(4, dto.getSno());
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
	// 6. �л���� 
	public ArrayList<StudentSwingDto> getStudents() {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn  = null;
		Statement  stmt = null;
		ResultSet  rs    = null;
		String sql = "SELECT ROWNUM RANK, SNAME||'('||SNO||')' SNAME, MNAME||'('||MNO||')' MNAME, SCORE" + 
				"    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M" + 
				"            WHERE S.MNO=M.MNO AND EXPEL=0" + 
				"            ORDER BY SCORE DESC)";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				
				dtos.add(new StudentSwingDto(rank, sname, mname, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 7. �����л���� 
	public ArrayList<StudentSwingDto> getStudentsExpel() {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn  = null;
		Statement  stmt = null;
		ResultSet  rs    = null;
		String sql = "SELECT ROWNUM RANK, SNAME||'('||SNO||')' SNAME, MNAME||'('||MNO||')' MNAME, SCORE" + 
				"    FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M" + 
				"            WHERE S.MNO=M.MNO AND EXPEL=1" + 
				"            ORDER BY SCORE DESC)";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				
				dtos.add(new StudentSwingDto(rank, sname, mname, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	// 8. ����ó�� 
	public int snoExpel(String sno) {
		int result = FAIL; 
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET EXPEL=1 WHERE SNO=?";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
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
}

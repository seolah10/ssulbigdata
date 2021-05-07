package com.lec.supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

//0. 레벨이름들 검색 : public Vector<String> getLevelNames()
//1. cId로 검색 : public CustomerDto cIdGetCustomer(int cId)
//2. 폰뒤4자리나 폰전체로 검색 : public ArrayList<CustomerDto> cTelGetCustomers(String cTel)
//3. 고객이름으로 검색 : public ArrayList<CustomerDto> cNameGetCustomers(String cName)
//4. 포인트로만 구매 public int buyWithPoint(int cAmount, int cId)
//5. 구매 public int buy(int cAmount, int cId)
//6. 등급별 출력 public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
//7. 전체 출력 public ArrayList<CustomerDto> getCustomers()
//8. 회원가입 public int insertCustomer(String cTel, String cName)
//9. 번호수정 public int updateCustomer(String cTel, int cId)
//10. 회원탈퇴 public int deleteCustomer(String cId)

public class CustomerDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static CustomerDao INSTANCE;
	public static CustomerDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new CustomerDao();
		}
		return INSTANCE;
	}
	private CustomerDao() {
		try { 
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 0. 레벨이름 검색 
	public Vector<String> getLevelNames() {
		Vector<String> levelNames = new Vector<String>();
		levelNames.add("");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT LEVELNAME FROM CUSTOM_LEVEL";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				levelNames.add(rs.getString("levelName"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				
			}
		}
		return levelNames;
	}
	// 1. 아이디로 검색 
	public CustomerDto cIdGetCustomer(int cId) {
		CustomerDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs   = null;
		
		String sql = "SELECT C_ID, C_TEL, C_NAME, C_POINT, C_AMOUNT, LEVELNAME, " + 
				"    (SELECT HIGH-C_AMOUNT+1 FROM CUSTOMER" + 
				"        WHERE C_ID=C.C_ID AND LEVEL_NO!=5) ForLEVELUP" + 
				"    FROM CUSTOMER C, CUSTOM_LEVEL L" + 
				"    WHERE C.LEVEL_NO=L.LEVEL_NO AND C_ID=?";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String cTel = rs.getString("cTel");
				String cName = rs.getString("cName");
				int cPoint = rs.getInt("cPoint");
				int cAmount = rs.getInt("cAmount");
				String levelName = rs.getString("levelName");
				int forLevelUp = rs.getInt("forLevelUp");
				
				dto = new CustomerDto(cId, cTel, cName, cPoint, cAmount, levelName, forLevelUp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				
			}
		}
		return dto; 
	}
	// 2. 폰번호 뒷 4자리나 폰번호 전체로 검색 
	public ArrayList<CustomerDto> cTelGetCustomer(String cTel) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs   = null;
		
		String sql = "SELECT C_ID, C_TEL, C_NAME, C_POINT, C_AMOUNT, LEVELNAME, " + 
				"    (SELECT HIGH-C_AMOUNT+1 FROM CUSTOMER" + 
				"        WHERE C_ID=C.C_ID AND LEVEL_NO!=5) ForLEVELUP" + 
				"    FROM CUSTOMER C, CUSTOM_LEVEL L" + 
				"    WHERE C.LEVEL_NO=L.LEVEL_NO AND C_TEL LIKE '%'||?";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cTel);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int cId = rs.getInt("cId");
				cTel = rs.getString("cTel");
				String cName = rs.getString("cName");
				int cPoint = rs.getInt("cPoint");
				int cAmount = rs.getInt("cAmount");
				String levelName = rs.getString("levelName");
				int forLevelUp = rs.getInt("forLevelUp");
				
				dtos.add(new CustomerDto(cId, cTel, cName, cPoint, cAmount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				
			}
		}
		return dtos;
	}
	// 3. 고객 이름으로 검색 
	public ArrayList<CustomerDto> cNameGetCustomer(String cName) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs   = null;
		
		String sql = "SELECT C_ID, C_TEL, C_NAME, C_POINT, C_AMOUNT, LEVELNAME, " + 
				"    (SELECT HIGH-C_AMOUNT+1 FROM CUSTOMER" + 
				"        WHERE C_ID=C.C_ID AND LEVEL_NO!=5) ForLEVELUP" + 
				"    FROM CUSTOMER C, CUSTOM_LEVEL L" + 
				"    WHERE C.LEVEL_NO=L.LEVEL_NO AND C_NAME=?";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int cId = rs.getInt("cId");
				String cTel = rs.getString("cTel");
				int cPoint = rs.getInt("cPoint");
				int cAmount = rs.getInt("cAmount");
				String levelName = rs.getString("levelName");
				int forLevelUp = rs.getInt("forLevelUp");
				
				dtos.add(new CustomerDto(cId, cTel, cName, cPoint, cAmount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				
			}
		}
		return dtos;
	}
	// 4. 포인트로만 구매 
	public int buyWithPoint (int cAmount, int cId) {
		int result = FAIL; 
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE CUSTOMER SET C_POINT = C_POINT - ? " + 
				"    WHERE C_ID=?";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cAmount);
			pstmt.setInt(2, cId);
			result = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				
			}
		}
		return result; 
	}
	// 5. 구매 
	public int buy (int cAmount, int cId) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE CUSTOMER SET C_POINT = ? * 0.05," + 
				"                    C_AMOUNT = C_AMOUNT + ?," + 
				"                    LEVEL_NO = (SELECT L.LEVEL_NO" + 
				"                                 FROM CUSTOMER C, CUSTOM_LEVEL L" + 
				"                                 WHERE C_AMOUNT + ? " + 
				"                                    BETWEEN LOW AND HIGH AND C_ID=?)" + 
				"                WHERE C_ID=?";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cAmount);
			pstmt.setInt(2, cAmount);
			pstmt.setInt(3, cAmount);
			pstmt.setInt(4, cId);
			pstmt.setInt(5, cId);
			result = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				
			}
		}
		return result;
	}
	// 6. 등급별 출력 
	public ArrayList<CustomerDto> levelNameGetCustomers(String levelName) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs   = null;
		
		String sql = "SELECT C_ID, C_TEL, C_NAME, C_POINT, C_AMOUNT, LEVELNAME," + 
				"        (SELECT HIGH-C_AMOUNT+1 FROM CUSTOMER" + 
				"            WHERE C_ID=C.C_ID AND LEVEL_NO!=5) ForLEVELUP" + 
				"    FROM  CUSTOMER C, CUSTOM_LEVEL L" + 
				"    WHERE C.LEVEL_NO = L.LEVEL_NO AND LEVELNAME='VVIP'" + 
				"    ORDER BY C_AMOUNT DESC";

		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);
			rs = pstmt.executeQuery();
	
			while(rs.next()) {
				int cId = rs.getInt("cId");
				String cTel = rs.getString("cTel");
				String cName = rs.getString("cName");
				int cPoint = rs.getInt("cPoint");
				int cAmount = rs.getInt("cAmount");
				int forLevelUp = rs.getInt("forLevelUp");
				
				dtos.add(new CustomerDto(cId, cTel, cName, cPoint, cAmount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				
			}
		}	
		return dtos;
	}
	// 7. 전체 출력 
	public ArrayList<CustomerDto> getCustomers() {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs   = null;
		
		String sql = "SELECT C_ID, C_TEL, C_NAME, C_POINT, C_AMOUNT, LEVELNAME," + 
				"        (SELECT HIGH-C_AMOUNT+1 FROM CUSTOMER" + 
				"            WHERE C_ID=C.C_ID AND LEVEL_NO!=5) ForLEVELUP" + 
				"    FROM  CUSTOMER C, CUSTOM_LEVEL L" + 
				"    WHERE C.LEVEL_NO = L.LEVEL_NO" + 
				"    ORDER BY C_AMOUNT DESC";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
	
			while(rs.next()) {
				int cId = rs.getInt("cId");
				String cTel = rs.getString("cTel");
				String cName = rs.getString("cName");
				int cPoint = rs.getInt("cPoint");
				int cAmount = rs.getInt("cAmount");
				String levelName = rs.getString("levelName");
				int forLevelUp = rs.getInt("forLevelUp");
				
				dtos.add(new CustomerDto(cId, cTel, cName, cPoint, cAmount, levelName, forLevelUp));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				
			}
		}	
		return dtos;
	}
	// 8. 회원가입 
	public int insertCustomer(String cTel, String cName) {
		int result = FAIL; 
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO CUSTOMER (C_ID, C_TEL, C_NAME) " + 
				"    VALUES (CUSTOMER_SEQ.NEXTVAL, ?, ?)";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cTel);
			pstmt.setString(2, cName);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				
			}
		}	
		return result;
	}
	// 9. 번호 수정 
	public int updateCustomer(String cTel, int cId) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE CUSTOMER SET C_TEL = ?" + 
				"    WHERE C_ID=?";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cTel);
			pstmt.setInt(2, cId);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				
			}
		}	
		return result;		
	}
	// 10. 회원 탈퇴
	public int deleteCustomer(String cId) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE C_ID=?";
		
		try { 
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cId);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (Exception e) {
				
			}
		}	
		return result;		
	}
}

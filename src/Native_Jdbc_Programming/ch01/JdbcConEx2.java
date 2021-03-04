package Native_Jdbc_Programming.ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Native_Jdbc_Programming.dto.Department;

public class JdbcConEx2 {
	/**
	 * JDBC 
	 *  2021.02.15
	 */
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		ArrayList<Department> list = new ArrayList<>();

		try {
			// 1. JDBC 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2.테이터베이스 커넥션 생성
			String url = "jdbc:mysql://localhost:3306/mysql_study?useSSL=false";
			String user = "user_mysql_study";
			String password = "rootroot";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("con" + con);

			// 3. Statement생성
			String sql = "insert  into department values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			System.out.println("stmt > " + pstmt);

			Department newDept = new Department(7, "회계",11);
			
			pstmt.setInt(1, newDept.getDeptno());
			pstmt.setString(2,newDept.getDeptName());
			pstmt.setInt(3, newDept.getFloor());
			System.out.println("pstmt2 > " + pstmt);
			
			//4. pstmt실행
			int res = pstmt.executeUpdate();
			if(res ==1) {
				System.out.println("추가 성공");
			}else {
				System.out.println("추가 실패");
			}
			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver Not Found");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			// 6. 커넥션 종료			
			try {pstmt.close();} catch (SQLException e) {}
			try {con.close(); } catch (SQLException e) {}
		}
		System.out.println("Department Query 결과는");
		for (Department d : list) {
			System.out.println(d);
		}
	}// main

}// class

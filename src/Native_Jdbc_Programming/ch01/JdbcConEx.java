package Native_Jdbc_Programming.ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Native_Jdbc_Programming.dto.Department;

public class JdbcConEx {
	/**
	 * JDBC 프로그램의 전형적인 실행순서
	 *  2021.02.15
	 */
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
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
			stmt = con.createStatement();
			System.out.println("stmt > " + stmt);

			// 4.쿼리 실행
			String sql = "select deptno, deptName, floor from department";
			rs = stmt.executeQuery(sql);

			// 5.쿼리 실행결과 출력

			while (rs.next()) {
				list.add(getDepartment(rs));
//				Department dept = getDepartment(rs);
//				System.out.println(dept);
			}
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver Not Found");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6. 커넥션 종료
			try {rs.close();  } catch (SQLException e) {}
			try {stmt.close();} catch (SQLException e) {}
			try {con.close(); } catch (SQLException e) {}
		}
		System.out.println("Department Query 결과는");
		for (Department d : list) {
			System.out.println(d);
		}
	}// main

	private static Department getDepartment(ResultSet rs) throws SQLException {
		int deptno = rs.getInt("deptno");
		String deptName = rs.getNString("deptName");
		int floor = rs.getInt("floor");
		return new Department(deptno, deptName, floor);
	}

}// class

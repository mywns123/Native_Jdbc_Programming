package Native_Jdbc_Programming.ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Native_Jdbc_Programming.dto.Department;

public class JdbcConEx3 {
	/**
	 * JDBC try-catch-resource
	 *  2021.02.15
	 */
	public static void main(String[] args) {
		ArrayList<Department> list = null;
		
		String url = "jdbc:mysql://localhost:3306/mysql_study?useSSL=false";
		String user = "user_mysql_study";
		String password = "rootroot";
		String sql = "select deptno, deptName, floor from department";
		try (
				Connection con = DriverManager.getConnection(url, user, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){
			
			// 1. JDBC 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			list = new ArrayList<>();
			
			while (rs.next()) {
				list.add(getDepartment(rs));
			}
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver Not Found");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

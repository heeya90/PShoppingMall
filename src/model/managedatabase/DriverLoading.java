package model.managedatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DriverLoading {

	public DriverLoading() { // 생성자에서 드라이버 로딩
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver); // 드라이버 로딩
		} catch (Exception e) {
			System.out.println("드라이버 로딩 예외발생" + e.getMessage());
		}
	}

	// 자바와 db간 커넥션을 return 해주는 메서드
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@oracle.risingsun7.cafe24.com:1521:orcl";
		String userid = "risingsun7";
		String userpw = "oracle9789";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userid, userpw);
		} catch (Exception e) {
			System.out.println("커넥션 연결 에러:" + e.getMessage());
		}
		return con;
	}

}
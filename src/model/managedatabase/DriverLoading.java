package model.managedatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DriverLoading {

	public DriverLoading() { // �����ڿ��� ����̹� �ε�
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver); // ����̹� �ε�
		} catch (Exception e) {
			System.out.println("����̹� �ε� ���ܹ߻�" + e.getMessage());
		}
	}

	// �ڹٿ� db�� Ŀ�ؼ��� return ���ִ� �޼���
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@oracle.risingsun7.cafe24.com:1521:orcl";
		String userid = "risingsun7";
		String userpw = "oracle9789";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userid, userpw);
		} catch (Exception e) {
			System.out.println("Ŀ�ؼ� ���� ����:" + e.getMessage());
		}
		return con;
	}

}
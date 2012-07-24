package model.managedatabase;

import java.sql.Connection;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class PoolCon {
	BasicDataSource ds;
	private Connection con = null;
	
	public PoolCon(){
		ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@oracle.risingsun7.cafe24.com:1521:orcl");
		ds.setUsername("risingsun7");
		ds.setPassword("oracle9789");
		ds.setInitialSize(10);
	}
	
	public Connection getCon(){
		try{
			con = ds.getConnection();
			//System.out.println(con.toString());
		}catch(Exception e){
			e.printStackTrace();
			//System.out.println("커넥션 연결 에러:" + e.getMessage());
		}		
		return con;
	}
}
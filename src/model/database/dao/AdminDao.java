package model.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.database.beans.Admin;
import model.managedatabase.DriverLoading;
import model.managedatabase.PoolCon;

public class AdminDao {
	//데이터베이스 연결(커넥션 풀 구현 예정)
	//insert, delete, update, selecte 메소드
	
	public Admin selectAdmin(){
		//Connection conn = new DriverLoading().getConnection();
		Connection pconn = new PoolCon().getCon();
		System.out.println("컨넥션받아옴");
		System.out.println(pconn);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Admin adm = new Admin();
		try{
			pstmt=pconn.prepareStatement("SELECT id, pw FROM t_admin");
			rs = pstmt.executeQuery();
			while(rs.next()){
				adm.setId(rs.getString("id"));
				adm.setPw(rs.getString("pw"));
				System.out.println(adm.getId()+adm.getPw());
			}
			return adm;
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("selectAdmin() 에러");
		}finally{
			try {
				rs.close();
				pstmt.close();
				pconn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	public void insertAdmin(){
		
	}
	public void deleteAdmin(){
		
	}
	public void updateAdmin(){
		
	}
}
package model.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.database.dto.Admin;
import model.managedatabase.DriverLoading;

public class AdminDao {
	//�����ͺ��̽� ����(Ŀ�ؼ� Ǯ)
	//insert, delete, update, selecte �޼ҵ�
	
	public Admin selectAdmin(){
		Connection conn = new DriverLoading().getConnection();
		//Connection conn = new PoolCon().getCon();
		System.out.println("���ؼǹ޾ƿ�");
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Admin adm = new Admin();
		try{
			pstmt=conn.prepareStatement("SELECT id, pw FROM t_admin");
			rs = pstmt.executeQuery();
			while(rs.next()){
				adm.setId(rs.getString("id"));
				adm.setPw(rs.getString("pw"));
				System.out.println(adm.getId()+adm.getPw());
			}
			return adm;
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("selectAdmin() ����");
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
package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.database.beans.Admin;
import model.database.dao.AdminDao;

public class AdmChk implements CommandHandler {

	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		//1.��ɾ�� ���õ� ����Ͻ� ���� ó��
		String id = request.getParameter("adminId");
		String pw = request.getParameter("adminPwd");
		System.out.println(id+" getParameter "+pw);
		
		AdminDao adminDao = new AdminDao();
		Admin adm = adminDao.selectAdmin();
		
		String mssg=null;
		
		System.out.println(adm.getId() + "   " +adm.getPw());
		
		if( id.equals(adm.getId()) && pw.equals(adm.getPw())){
			mssg = "ok";
		}else{
			if(!id.equals(adm.getId())){
				mssg = "id";
			}
			if(!pw.equals(adm.getPw())){
				mssg = "pw";
			}
		}
			
		//2.�� ���������� ����� ���� ����
		System.out.println(mssg);
		request.setAttribute("data", mssg);
		//3.�� �������� URI ����
		//return "/havemenu.tiles";
		return "/sitehelper/sitehelper_login.jsp?data="+mssg;
	}
}

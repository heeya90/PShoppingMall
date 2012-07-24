package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.database.dao.AdminDao;
import model.database.dto.Admin;

public class AdmChk implements CommandHandler {
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		//1.��ɾ�� ���õ� ����Ͻ� ���� ó��
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		AdminDao adminDao = new AdminDao();
		/*---------------------------*/
		Admin adm = adminDao.selectAdmin();
		String mssg=null;
		
		System.out.println(adm.getId() + adm.getPw());
		if( id.equals(adm.getId()) && pw.equals(adm.getPw())){
			mssg = "������ �α��� ����!!";
		}else{
			if(!id.equals(adm.getId())){
				mssg = "���̵� Ʋ�Ƚ��ϴ�.";
			}
			if(!pw.equals(adm.getPw())){
				mssg = "��й�ȣ�� Ʋ�Ƚ��ϴ�.";
			}
		}
			
		//2.�� ���������� ����� ���� ����
		request.setAttribute("1", mssg);
		//3.�� �������� URI ����
		return "/1.tiles";
	}
}

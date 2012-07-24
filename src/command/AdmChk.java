package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.database.beans.Admin;
import model.database.dao.AdminDao;

public class AdmChk implements CommandHandler {

	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		//1.명령어와 관련된 비즈니스 로직 처리
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
			
		//2.뷰 페이지에서 사용할 정보 저장
		System.out.println(mssg);
		request.setAttribute("data", mssg);
		//3.뷰 페이지의 URI 리턴
		//return "/havemenu.tiles";
		return "/sitehelper/sitehelper_login.jsp?data="+mssg;
	}
}

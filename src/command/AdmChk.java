package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.database.dao.AdminDao;
import model.database.dto.Admin;

public class AdmChk implements CommandHandler {
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		//1.명령어와 관련된 비즈니스 로직 처리
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		AdminDao adminDao = new AdminDao();
		/*---------------------------*/
		Admin adm = adminDao.selectAdmin();
		String mssg=null;
		
		System.out.println(adm.getId() + adm.getPw());
		if( id.equals(adm.getId()) && pw.equals(adm.getPw())){
			mssg = "관리자 로그인 성공!!";
		}else{
			if(!id.equals(adm.getId())){
				mssg = "아이디가 틀렸습니다.";
			}
			if(!pw.equals(adm.getPw())){
				mssg = "비밀번호가 틀렸습니다.";
			}
		}
			
		//2.뷰 페이지에서 사용할 정보 저장
		request.setAttribute("1", mssg);
		//3.뷰 페이지의 URI 리턴
		return "/1.tiles";
	}
}

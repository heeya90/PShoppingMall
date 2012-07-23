package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;

public class MainHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		//1.명령어와 관련된 비즈니스 로직 처리
		//2.뷰 페이지에서 사용할 정보 저장
		request.setAttribute("1", "이게 MVC 패턴으로 타일즈를 구현한거야!!");
		//3.뷰 페이지의 URI 리턴
		return "/1.tiles";
	}

}

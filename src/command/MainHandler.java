package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;

public class MainHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		//1.��ɾ�� ���õ� ����Ͻ� ���� ó��
		//2.�� ���������� ����� ���� ����
		request.setAttribute("1", "�̰� MVC �������� Ÿ��� �����Ѱž�!!");
		//3.�� �������� URI ����
		return "/1.tiles";
	}

}

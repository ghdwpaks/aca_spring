package info.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.repository.InfoVo;
import info.service.JoinService;

public class JoinController implements Controller{

	private JoinService joinService;
	
	public JoinController(JoinService joinService) {
		System.out.println("JoinController 생성");
		this.joinService = joinService;
	}
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getMethod();
		if(method.equals("GET")) {
			return "/join";
		}else {
			String infoId = req.getParameter("info_id");
			String infoPw = req.getParameter("info_pw");
			String infoNick = req.getParameter("info_nick");
			InfoVo vo = new InfoVo(infoId, infoPw, infoNick);
			joinService.join(vo);
			return "redirect:/";
		}
	}
	
}

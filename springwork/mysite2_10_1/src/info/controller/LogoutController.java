package info.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import info.repository.InfoVo;

public class LogoutController implements Controller{

	public LogoutController() {
		System.out.println("LogoutController 생성");
	}
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		InfoVo vo = (InfoVo)session.getAttribute("user");
		System.out.println(vo.getInfoId() + "회원 로그아웃");
		session.invalidate();
		return "redirect:/";
	}

}

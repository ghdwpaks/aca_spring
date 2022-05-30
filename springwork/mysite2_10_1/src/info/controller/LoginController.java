package info.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.service.LoginCommand;
import info.service.LoginService;

public class LoginController implements Controller{
	private LoginService loginService;
	
	public LoginController(LoginService loginService) {
		System.out.println("LoginController 생성");
		this.loginService = loginService;
	}
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if(method.equals("GET")) {
			Cookie[] cookies = req.getCookies();
			String id = "";
			for(int i = 0; i < cookies.length; i++){
				String cookie = cookies[i].getName();
				if(cookie.equals("rememberId")){
					id = cookies[i].getValue();			
				}
			}
			req.setAttribute("id", id);
			return "/login";
		}else {
			LoginCommand cmdObj = new LoginCommand();
			cmdObj.setInfoId(req.getParameter("infoId"));
			cmdObj.setInfoPw(req.getParameter("infoPw"));
			cmdObj.setRememberId(req.getParameter("rememberId"));
			return "redirect:" + loginService.login(req, resp, cmdObj);
		}
	}

}

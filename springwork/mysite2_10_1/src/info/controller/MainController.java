package info.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Controller{

	public MainController() {
		System.out.println("MainController 생성");
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return "/index";
	}
	
}

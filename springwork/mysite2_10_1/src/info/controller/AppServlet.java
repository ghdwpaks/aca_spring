package info.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.repository.InfoDao;
import info.service.JoinService;
import info.service.LoginService;

public class AppServlet extends HttpServlet{
	
	HashMap<String, Controller> map = new HashMap<>();
	
	public AppServlet() {
		System.out.println("Front Controller 서블릿 생성");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("초기화");
		InfoDao infoDao = InfoDao.getInstance();
		
		JoinService joinService = new JoinService(infoDao);
		LoginService loginService = new LoginService(infoDao);

		map.put("/", new MainController());
		map.put("/join", new JoinController(joinService));
		map.put("/login", new LoginController(loginService));
		map.put("/logout", new LogoutController());	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String cmd = uri.substring(req.getContextPath().length());
		String viewPage = null;
		Controller controller = null;
		System.out.println("cmd:" + cmd);
		if(cmd.equals("/")) {
			controller = map.get("/");
		}else if(cmd.startsWith("/join")) {
			controller = map.get("/join");
		}else if(cmd.startsWith("/login")) {
			controller = map.get("/login");
		}else if(cmd.equals("/logout")) {
			controller = map.get("/logout");
		}
		
		String prefix = "/WEB-INF/views";
		String suffix = ".jsp";
		viewPage = controller.process(req, resp);
		System.out.println("viewPage:" + viewPage);
		if(viewPage.startsWith("redirect:")) {
			resp.sendRedirect(req.getContextPath() + viewPage.substring("redirect:".length()));
		}else {
			req.getRequestDispatcher(prefix+viewPage+suffix).forward(req, resp);
		}
	}
	
}

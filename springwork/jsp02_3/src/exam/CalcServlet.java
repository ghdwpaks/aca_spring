package exam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet{
	
	private Map<String, Calculator> map = new HashMap<>();
	
	public CalcServlet() {
		map.put("/calc/add", new Add());
		map.put("/calc/min", new Min());
		map.put("/calc/mul", new Mul());
		map.put("/calc/div", new Div());
	}
	
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
		String command = uri.substring(req.getContextPath().length());
		
		String viewPage = "";
		
		if(command.equals("/calc")) {
			viewPage = "/calcForm.jsp";
		}else {
			Calculator calc = map.get(command);
			viewPage = calc.calc(req, resp);
		}
		
		req.getRequestDispatcher(viewPage).forward(req, resp);
	}
}





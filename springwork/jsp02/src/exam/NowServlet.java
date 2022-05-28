package exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet{
	
	public NowServlet() {
		System.out.println("NowServlet");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("NowServlet doGet Act");
		Date now = new Date();
		req.setAttribute("now", now);
		req.getRequestDispatcher("/now.jsp").forward(req, resp);
	}
}










package info.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.repository.InfoDao;
import info.repository.InfoVo;

public class LoginService {
	private InfoDao infoDao;
	
	public LoginService(InfoDao infoDao) {
		System.out.println("LoginService 생성");
		this.infoDao = infoDao;
	}
	
	public String login(HttpServletRequest req, HttpServletResponse resp, LoginCommand cmd) {
		InfoVo vo = infoDao.selectOne(cmd.getInfoId());
		if(vo == null){
			return "/login";
		}else if(cmd.getInfoPw().equals(vo.getInfoPw())){
			String rid = cmd.getRememberId();
			if(rid != null && rid.equals("1")){
				Cookie cookie = new Cookie("rememberId", cmd.getInfoId());
				cookie.setMaxAge(60);
				resp.addCookie(cookie);
			}else{
				Cookie cookie = new Cookie("rememberId", cmd.getInfoId());
				cookie.setMaxAge(0); //브라우저에 쿠키 만료
				resp.addCookie(cookie);
			}
					
			req.getSession().setAttribute("user", vo);
			return "/";
		}else{
			return "/login";
		}
	}
}

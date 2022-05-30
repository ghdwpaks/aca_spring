package info.service;

import info.repository.InfoDao;
import info.repository.InfoVo;

public class JoinService {
	private InfoDao infoDao;
	
	public JoinService(InfoDao infoDao) {
		System.out.println("JoinService 생성");
		this.infoDao = infoDao;
	}
	
	public void join(InfoVo vo) {
		infoDao.insertInfo(vo);
	}
}

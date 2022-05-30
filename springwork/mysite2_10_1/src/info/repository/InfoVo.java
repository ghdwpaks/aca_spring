package info.repository;

import java.time.LocalDateTime;

public class InfoVo {
	private long infoNo;
	private String infoId;
	private String infoPw;
	private String infoNick;
	private LocalDateTime infoRegdate;
	
	public InfoVo() {}
	
	public InfoVo(String infoId, String infoPw, String infoNick) {
		this.infoId = infoId;
		this.infoPw = infoPw;
		this.infoNick = infoNick;
	}
	public long getInfoNo() {
		return infoNo;
	}
	public void setInfoNo(long infoNo) {
		this.infoNo = infoNo;
	}
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getInfoPw() {
		return infoPw;
	}
	public void setInfoPw(String infoPw) {
		this.infoPw = infoPw;
	}
	public String getInfoNick() {
		return infoNick;
	}
	public void setInfoNick(String infoNick) {
		this.infoNick = infoNick;
	}
	public LocalDateTime getInfoRegdate() {
		return infoRegdate;
	}
	public void setInfoRegdate(LocalDateTime infoRegdate) {
		this.infoRegdate = infoRegdate;
	}
	@Override
	public String toString() {
		return "InfoVo [infoNo=" + infoNo + ", infoId=" + infoId + ", infoPw=" + infoPw + ", infoNick=" + infoNick
				+ ", infoRegdate=" + infoRegdate + "]";
	}
}

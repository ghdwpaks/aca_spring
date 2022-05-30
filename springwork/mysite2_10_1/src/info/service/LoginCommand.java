package info.service;

public class LoginCommand {
	private String infoId;
	private String infoPw;
	private String rememberId;
	public String getRememberId() {
		return rememberId;
	}
	public void setRememberId(String rememberId) {
		this.rememberId = rememberId;
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
}

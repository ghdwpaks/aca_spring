package info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InfoDao {

	public InfoDao() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 클래스 로딩 성공");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void insertInfo(InfoVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO INFO(INFO_NO, INFO_ID, INFO_PW, INFO_NICK, INFO_REGDATE) ");
		sql.append("VALUES (SEQ_INFO.NEXTVAL, ?, ?, ?, SYSDATE)");
		System.out.println("sql:" + sql.toString());
		try {
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "springuser", "1234");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:itspring"
					+ "", "root", "root");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getInfoId());
			pstmt.setString(2, vo.getInfoPw());
			pstmt.setString(3, vo.getInfoNick());
			pstmt.executeUpdate();
			System.out.println("등록 완료");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

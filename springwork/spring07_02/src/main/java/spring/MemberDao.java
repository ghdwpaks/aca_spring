package spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) {
		List<Member> result = jdbcTemplate.query(
				"SELECT * FROM MEMBER WHERE EMAIL=?", 
				new RowMapper<Member>() { //익명 중첩 클래스 형식
						
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(
								rs.getString("EMAIL"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"),
								rs.getTimestamp("REGDATE"));
						member.setId(rs.getLong("ID"));
						
						return member;
					}
					
				}, email);
		return result.isEmpty() ? null : result.get(0);
	}
	
	public void insert(Member member) {
	}
	
	public void update(Member member) {
	}
	
	public List<Member> selectAll(){
		return null;
	}
	
}



package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) {
		List<Member> result = jdbcTemplate.query(
				"SELECT * FROM MEMBER WHERE EMAIL=?", 
				new MemberRowMapper(), 
				email);
		return result.isEmpty() ? null : result.get(0);
	}
	
	public void insert(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement pstmt = con.prepareStatement(
								"INSERT INTO MEMBER(ID, EMAIL, PASSWORD, NAME, REGDATE) "
								+ "values (NULL, ?, ?, ?, now())",
						new String[] {"ID"});
						
						pstmt.setString(1, member.getEmail());
						pstmt.setString(2, member.getPassword());
						pstmt.setString(3, member.getName());
						return pstmt;
					}
					
				}, keyHolder); // new String[] {"ID"}지정한 컬럼의 삽입된 값을 얻어올 수 있음
		Number id = keyHolder.getKey();
		member.setId(id.longValue());
	}
	
	public void update(Member member) {
		jdbcTemplate.update(
				"UPDATE MEMBER SET NAME=?, PASSWORD=? WHERE EMAIL=?",
				member.getName(), member.getPassword(), member.getEmail());
	}
	public void update2(Member member) {
		jdbcTemplate.update(
				new PreparedStatementCreator() {

					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement pstmt = con.prepareStatement(
								"UPDATE MEMBER SET NAME=?, PASSWORD=? WHERE EMAIL=?");
						pstmt.setString(1, member.getName());
						pstmt.setString(2, member.getPassword());
						pstmt.setString(3, member.getEmail());
						return pstmt;
					}
					
				});
	}
	
	public List<Member> selectAll(){
		List<Member> result = jdbcTemplate.query(
				"SELECT * FROM MEMBER", 
				new MemberRowMapper());
		return result;
	}
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject( //결과가 하나인 쿼리에 사용
				"SELECT COUNT(*) FROM MEMBER", 
				Integer.class);
		return count;
	}
	
	public Member selectById(Long id) {
		Member result = jdbcTemplate.queryForObject(
				"SELECT * FROM MEMBER WHERE ID=?", 
				new MemberRowMapper(), 
				id);
		return result;
	}
	
}












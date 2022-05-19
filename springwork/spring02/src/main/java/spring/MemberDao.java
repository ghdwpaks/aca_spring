package spring;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long nextId = 0;
	private Map<String, Member> db = new HashMap<>();
	
	public Member selectByEmail(String email) {
		return db.get(email);
	}
	
	public void insert(Member member) {
		member.setId(++nextId);
		db.put(member.getEmail(), member);
	}
	
	public void update(Member member) {
		db.put(member.getEmail(), member);
	}
	
	public ArrayList<Member> selectAll() {
		return new ArrayList<Member>(db.values());
	}

	
}

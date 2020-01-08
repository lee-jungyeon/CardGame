package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Member;
import vo.Report;

public class MemberDao {
	public List<Member> getLevel(Connection conn, Member member) throws Exception{
		System.out.println("get level DAO");
		String sql ="SELECT member_id, level, exp FROM member WHERE member_id = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,member.getMemberId());
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Member mem = new Member();
			mem.setMemberId(rs.getString("member_id"));
			mem.setLevel(rs.getInt("level"));
			mem.setExp(rs.getInt("exp"));
			list.add(mem);
		}
		System.out.println(list);
		rs.close();
		stmt.close();
		
		return list;
	}


	public void updateLevel(Member member, Connection conn) throws Exception {
		System.out.println("addMember Dao 도착");
		PreparedStatement stmt = null;
		String sql = "update member set level=?, exp=? where member_id=?";
		
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, member.getLevel());
			stmt.setInt(2, member.getExp());
			stmt.setString(3, member.getMemberId());
			stmt.executeUpdate();
		
	}
	
	public void deleteMember(Connection conn, Member member) throws Exception {
		System.out.println("del도착 :"+ member);
		
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM member WHERE member_id=? AND member_pw=?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		stmt.executeUpdate();
		
	}	 
	public void updateMember(Connection conn, Member member) throws Exception {
		System.out.println("up도착 :"+ member);
		
		PreparedStatement stmt = null;
		
		String sql = "UPDATE member SET member_pw=? WHERE member_id=?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberPw());
		stmt.setString(2, member.getMemberId());
		
		stmt.executeUpdate();
		
	}	 
	public void insertMember(Connection conn, Member member) throws Exception {
		System.out.println("도착 :"+member);
		
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO member(member_id, member_pw, member_level)VALUES(?,?,'Y')";
	
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		stmt.executeUpdate();
		
			 
		}
		

	

	/*
	 * SELECT member_id FROM member 
	 * WHERE member_id =? AND member_pw=? AND member_level='Y';
	 */
	public Member login(Connection conn, Member member)throws Exception {
		System.out.println("h");
		Member returnMember = null;
		PreparedStatement stmt= null;
		System.out.println(member);
		String sql="SELECT member_id FROM member WHERE member_id =? AND member_pw=? AND member_level='Y'";
		ResultSet rs = null;
		try {
			stmt= conn.prepareStatement(sql);
			
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rs= stmt.executeQuery();
			if(rs.next()){
				 returnMember = new Member();
				 returnMember.setMemberId(rs.getString("member_id"));
				 System.out.println(returnMember);
			}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		System.out.println("?");
		return returnMember;
	}
}

package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import vo.Member;

public class MemberService {
	
	private MemberDao memberDao;
	public String login(Member member) {
	System.out.println("servicelogin 도착 :"+member);
	Member returnMember = null;
	Connection conn = null;

	try {
		DBService dbService = new DBService();
		conn = dbService.getConnection();
		conn.setAutoCommit(false);
		
		MemberDao memberDao = new MemberDao();
		returnMember = memberDao.login(conn, member);
		System.out.println(returnMember);
		conn.commit();
	}catch(Exception e) {
		try {
			conn.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		e.printStackTrace();
	}finally {
			try {
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	return returnMember.getMemberId();
	
		}
	}

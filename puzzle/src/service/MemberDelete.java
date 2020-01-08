package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import dao.ReportDao;
import vo.Member;
import vo.Report;

public class MemberDelete {
	private MemberDao memberDao;
	public void deleteMember(Member member) {
		System.out.println("도착 delete:"+member);
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			
			memberDao= new MemberDao();
			memberDao.deleteMember(conn, member);
	
			System.out.println(member);
			conn.commit();
				
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
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
	}
}

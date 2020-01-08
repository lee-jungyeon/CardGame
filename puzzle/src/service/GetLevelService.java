package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import dao.ReportDao;
import vo.Member;
import vo.Report;

public class GetLevelService {
	private MemberDao memberDao;
	public List<Member> getlevel(Member member) {
		List<Member> list= new ArrayList<Member>();	
	
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			
			memberDao = new MemberDao();
			list = memberDao.getLevel(conn,member);
	
			System.out.println(list);
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
		return list;
		
		

		}
	




	}



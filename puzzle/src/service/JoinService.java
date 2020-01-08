package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import vo.Member;

public class JoinService {
	private MemberDao memberDao;
	public void insertMember(Member member) {
		System.out.println("도착2:"+member);
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			
			memberDao = new MemberDao();
			memberDao.insertMember(conn, member);
	
			System.out.println(member);
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
		
		
			}
		}


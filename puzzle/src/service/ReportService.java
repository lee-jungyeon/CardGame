package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ReportDao;
import vo.Member;
import vo.Report;

public class ReportService {
	private ReportDao reportDao;
	public void insertReport(Report report) {
		System.out.println("도착2:"+report);
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			
			reportDao = new ReportDao();
			reportDao.insertReport(conn, report);
	
			System.out.println(report);
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




package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ReportDao;
import vo.Report;

public class ReportListMyService {
	private ReportDao reportDao;
	public List<Report>selectReportMyList(Report report){
		System.out.println("service도착My");
		List<Report>list =new ArrayList<Report>();
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			
			reportDao = new ReportDao();
			list = reportDao.selectReportMyList(conn,report);
	
			System.out.println("dao넘어온: "+list);
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
		System.out.println("service도착My : " + list);
		return list;
		
		}
	}
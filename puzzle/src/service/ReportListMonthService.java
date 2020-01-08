package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ReportDao;
import vo.Report;

public class ReportListMonthService {
	private ReportDao reportDao;
	public List<Report> selectReportMonthList() {
		List<Report> list= new ArrayList<Report>();	
	
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			
			reportDao = new ReportDao();
			list = reportDao.selectReportMonthList(conn);
	
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


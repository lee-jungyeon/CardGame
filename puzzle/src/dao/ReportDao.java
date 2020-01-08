package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import vo.Member;
import vo.Report;

public class ReportDao {

	public List<Report> selectReportMyList(Connection conn, Report report){
		System.out.println("dao도착My");
		List<Report> list= new ArrayList<Report>();	
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT report_id, member_id, count, timer, report_date FROM report WHERE member_id=? ORDER BY timer ASC, count ASC ";
		try {
			stmt= conn.prepareStatement(sql);
			stmt.setString(1, report.getMember().getMemberId());
			rs= stmt.executeQuery();
			
			while(rs.next()){
				Report r= new Report();
				r.setMember(new Member());
				r.getMember().setMemberId(rs.getString("member_id"));
				r.setReportId(rs.getInt("report_id"));
				r.setReportDate(rs.getString("report_date"));
				r.setCount(rs.getInt("count"));
				r.setTimer(rs.getInt("timer"));
				list.add(r);
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
		System.out.println("dao : "+list);
		return  list;
	}
	
	
	public List<Report> selectReportMonthList(Connection conn){
		List<Report> list= new ArrayList<Report>();	
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT report_id, member_id, count, timer, report_date FROM report WHERE Year(report_date) = Year(Now()) And Month(report_date) = Month(Now()) ORDER BY timer ASC, count ASC LIMIT 10";
		try {
			stmt= conn.prepareStatement(sql);
			rs= stmt.executeQuery();
			
			while(rs.next()){
				Report r= new Report();
				r.setMember(new Member());
				r.getMember().setMemberId(rs.getString("member_id"));
				r.setReportId(rs.getInt("report_id"));
				r.setReportDate(rs.getString("report_date"));
				r.setCount(rs.getInt("count"));
				r.setTimer(rs.getInt("timer"));
				list.add(r);
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
		return  list;
	}
	public List<Report> selectReportTodayList(Connection conn){
		List<Report> list= new ArrayList<Report>();	
		System.out.println("dao"+list);
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT report_id, member_id, count, timer, report_date FROM report WHERE date(report_date) = date(now()) ORDER BY timer ASC, count ASC LIMIT 10 ";
		try {
			stmt= conn.prepareStatement(sql);
			rs= stmt.executeQuery();
			
			while(rs.next()){
				Report r= new Report();
				r.setMember(new Member());
				r.getMember().setMemberId(rs.getString("member_id"));
				r.setReportId(rs.getInt("report_id"));
				r.setReportDate(rs.getString("report_date"));
				r.setCount(rs.getInt("count"));
				r.setTimer(rs.getInt("timer"));
				list.add(r);
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
		System.out.println("?"+list);
		return  list;
	}
	
	public List<Report> selectReportList(Connection conn){
		List<Report> list= new ArrayList<Report>();	
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT report_id, member_id, count, timer, report_date FROM report ORDER BY timer ASC, count ASC LIMIT 10";
		try {
			stmt= conn.prepareStatement(sql);
			rs= stmt.executeQuery();
			
			while(rs.next()){
				Report r= new Report();
				r.setMember(new Member());
				r.getMember().setMemberId(rs.getString("member_id"));
				r.setReportId(rs.getInt("report_id"));
				r.setReportDate(rs.getString("report_date"));
				r.setCount(rs.getInt("count"));
				r.setTimer(rs.getInt("timer"));
				list.add(r);
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
		return  list;
	}

	public void insertReport(Connection conn, Report report) throws Exception {
		System.out.println("도착 :"+ report);
		
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO report(member_id, report_date, count, timer,level)VALUES(?,now(),?,?,?)";
	
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, report.getMember().getMemberId());
		stmt.setInt(2, report.getCount());
		stmt.setInt(3, report.getTimer());
		stmt.setInt(4, report.getLevel());
		
		stmt.executeUpdate();
		
			 
		}
		
		
	
}
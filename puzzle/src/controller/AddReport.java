package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.JoinService;
import service.ReportService;
import vo.Member;
import vo.Report;

@WebServlet("/AddReport")
public class AddReport extends HttpServlet {
	private ReportService reportService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet");
		String memberId =request.getParameter("memberId");
		int	count =Integer.parseInt(request.getParameter("count"));
		int	timer =Integer.parseInt(request.getParameter("timerNum"));
		int	level =Integer.parseInt(request.getParameter("level"));
	 	System.out.println(" memberId: "+memberId+ " count:"+count+" timer"+timer+" level : "+level);
	 	
	 	reportService = new ReportService();
	 	Report r = new Report();
	 	r.setMember(new Member());
	 	r.getMember().setMemberId(memberId);
	 	r.setCount(count);
		r.setTimer(timer);
		r.setLevel(level);
	 	System.out.println("service: "+r);
	 	
	 	reportService.insertReport(r);
	}

}
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ReportListMonthService;
import service.ReportListMyService;
import vo.Member;
import vo.Report;


@WebServlet("/RreporyMyListServlet")
public class RreporyMyListServlet extends HttpServlet {
	private ReportListMyService reportListMyService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String memberId = request.getParameter("memberId");
		System.out.println("리스트도착My"+memberId);
		
		Report r = new Report();
	 	r.setMember(new Member());
	 	r.getMember().setMemberId(memberId);
		reportListMyService = new ReportListMyService();
		List<Report> list = reportListMyService.selectReportMyList(r);
		System.out.println("리스트도착My2"+memberId);
		
		Gson gson = new Gson();
		String jsonList= gson.toJson(list);
		response.getWriter().write( jsonList);
	}


	}

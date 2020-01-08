package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ReportListService;
import service.ReportListTodayService;
import vo.Report;


@WebServlet("/ReportListTodayServlet")
public class ReportListTodayServlet extends HttpServlet {
	
	private ReportListTodayService reportListTodayService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("리스트도착");
		response.setContentType("application/json;charset=utf-8");
		
		reportListTodayService = new ReportListTodayService();
		List<Report> list = reportListTodayService.selectReportTodayList();
		
		
		Gson gson = new Gson();
		String jsonList= gson.toJson(list);
		response.getWriter().write( jsonList);
	}


	}

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
import service.ReportListTodayService;
import vo.Report;


@WebServlet("/ReportListMonthServlet")
public class ReportListMonthServlet extends HttpServlet {
	
	private ReportListMonthService reportListMonthService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("리스트도착month");
		response.setContentType("application/json;charset=utf-8");
		
		reportListMonthService = new ReportListMonthService();
		List<Report> list = reportListMonthService.selectReportMonthList();
		
		
		Gson gson = new Gson();
		String jsonList= gson.toJson(list);
		response.getWriter().write( jsonList);
	}


	}

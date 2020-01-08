package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ReportDao;

import service.MemberService;
import service.ReportListService;
import service.ReportService;
import vo.Report;




@WebServlet("/ReportServlet")
public class ReportListServlet extends HttpServlet {
	
	private ReportListService reportListService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("리스트도착");
		response.setContentType("application/json;charset=utf-8");
		
		reportListService = new ReportListService();
		List<Report> list = reportListService.selectReportList();
		
		
		Gson gson = new Gson();
		String jsonList= gson.toJson(list);
		response.getWriter().write( jsonList);
	}


	}



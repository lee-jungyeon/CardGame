package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.MemberDelete;
import service.ReportListMyService;
import vo.Member;
import vo.Report;


@WebServlet("/MemberDeleteServlet")
public class MemberDeleteServlet extends HttpServlet {
	
	private MemberDelete memberDelete;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		System.out.println("리스트도착del"+memberId+"리스트도착del"+memberPw);
	
		
		Member m = new Member();
	 	m.setMemberId(memberId);
	 	m.setMemberPw(memberPw);
	 	memberDelete = new MemberDelete();
	 	memberDelete.deleteMember(m);
	 	System.out.println("리스트도착del2"+memberId+"리스트도착del2"+memberPw);
		

		Gson gson = new Gson();
		String json= gson.toJson(m);
		response.getWriter().write(json);
	
	}


	
	}



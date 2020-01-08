package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.MemberUpdate;
import service.MemberDelete;

import vo.Member;
import vo.Report;

@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
     private MemberUpdate memberUpdate;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String memberId = request.getParameter("memberId");
		String memberPw= request.getParameter("memberPw");
		System.out.println("리스트도착upid"+memberId);
		System.out.println("리스트도착uppw"+memberPw);
		
		
		Member m = new Member();
	 	m.setMemberId(memberId);
	 	m.setMemberPw(memberPw);
	 	memberUpdate = new MemberUpdate();
		memberUpdate.updateMember(m);
		

		Gson gson = new Gson();
		String json= gson.toJson(m);
		response.getWriter().write(json);
	
	}
}
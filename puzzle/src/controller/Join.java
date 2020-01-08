package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.JoinService;
import vo.Member;


@WebServlet("/Join")
public class Join extends HttpServlet {
	private JoinService joinService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId =request.getParameter("Id");
	 	String memberPw =request.getParameter("Pw");
	 	System.out.println("service1: "+memberId+ "pw:"+memberPw);
	 	
	 	joinService = new JoinService();
	 	Member m = new Member();
	 	m.setMemberId(memberId);
	 	m.setMemberPw(memberPw);
	 	System.out.println("service: "+m);
	 	
	 	joinService.insertMember(m);
	}

}

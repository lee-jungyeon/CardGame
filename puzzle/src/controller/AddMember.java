package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.AddMemberService;
import service.MemberUpdate;
import vo.Member;


@WebServlet("/AddMember")
public class AddMember extends HttpServlet {
	 private AddMemberService addMemberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		int level = Integer.parseInt(request.getParameter("level"));
		int exp = Integer.parseInt(request.getParameter("exp"));
		String memberId = request.getParameter("memberId");
		
		System.out.println("AddMember level:"+level+"exp: "+exp+"id"+memberId);
	
		//member객체에 set
		Member member = new Member();
		member.setExp(exp);
		member.setLevel(level);
		member.setMemberId(memberId);
		
		System.out.println("member에 level값은:"+member);
		
		addMemberService = new AddMemberService();
		addMemberService.updateLevel(member);

		Gson gson = new Gson();
		String json= gson.toJson(member);
		response.getWriter().write(json);
	}

}

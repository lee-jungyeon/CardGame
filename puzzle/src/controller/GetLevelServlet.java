package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.GetLevelService;

import vo.Member;

@WebServlet("/GetLevelServlet")
public class GetLevelServlet extends HttpServlet {
	private GetLevelService getLevelService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		String memberId = request.getParameter("memberId");
		Member member = new Member();
		member.setMemberId(memberId);
		
		getLevelService = new GetLevelService();
		List<Member> list =getLevelService.getlevel(member);
		System.out.println("Servlet List: "+list);
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println("JSON: "+json);
		response.getWriter().write(json);

	}


	}



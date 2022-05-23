package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.controller.Action;
import com.user.controller.ActionForward;
import com.user.model.UserDAO;

public class updateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		

		

		UserDAO dao  = UserDAO.getInstance();
		
		String name = request.getParameter("name");
		int age  = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		
		System.out.println(id+name+age+phone+email);
		
		int result = dao.updateUser(name,age,phone,email,id);
		System.out.println(result);
		

		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('회원정보가 변경되었습니다.')");
		out.println("location.href='goIndex.do'");
		out.println("</script>");
				
		return null;
	
		
	}

}

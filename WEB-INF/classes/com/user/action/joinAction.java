package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.controller.Action;
import com.user.controller.ActionForward;
import com.user.model.UserDAO;
import com.user.model.UserDTO;

public class joinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		UserDAO dao  = UserDAO.getInstance();
		UserDTO dto = new UserDTO();
		dto.setId(request.getParameter("id"));
		dto.setPwd(request.getParameter("pwd"));
		dto.setName(request.getParameter("name"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setPhone(request.getParameter("phone"));
		dto.setEmail(request.getParameter("email"));
		
		
		int result = dao.InsertUser(dto);

        System.out.println(result);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('회원가입이 완료되었습니다.')");
		out.println("location.href='goLogin.do'");
		out.println("</script>");

		return null;

		
		
		
	}

}

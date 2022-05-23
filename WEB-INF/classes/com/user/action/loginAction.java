package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.controller.Action;
import com.user.controller.ActionForward;
import com.user.model.UserDAO;
import com.user.model.UserDTO;

public class loginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		UserDAO dao  = UserDAO.getInstance();
		
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		List<UserDTO> list = dao.getUser(id);
		
		System.out.println(list);
		System.out.println(id+pwd);
		
		int result = dao.Login(id, pwd);
		
	
		System.out.println(result);
		
		ActionForward forward = new ActionForward(); 
		if ( result <= 0 ) {
			//아이디 또는 비밀번호가 맞지 않다고 띄워주세요
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디 또는 비밀번호가 맞지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
			System.out.println("과연:"+result);
			

		} else {
			
			// 세션에 저장해주세요
			HttpSession session = request.getSession(true);
	        session.setAttribute("id", id);
			
			forward.setRedirect(false);
			forward.setPath("index.jsp");

		}
		

		return forward;
		
		
		
	}

}

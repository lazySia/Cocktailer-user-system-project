package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.controller.Action;
import com.user.controller.ActionForward;
import com.user.model.UserDAO;

public class updatePwdAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		UserDAO dao  = UserDAO.getInstance();
		
		String id = request.getParameter("id");
		String oldpwd = request.getParameter("old-pwd");
		String pwd = request.getParameter("pwd");		
		String pwd2 = request.getParameter("pwd2");
		
		String daoResult = dao.selectPwd(id);
		
		PrintWriter out = response.getWriter();
		if (!oldpwd.equals(daoResult)) {
			out.println("<script>");
			out.println("alert('기존 비밀번호가 일치하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else if (!pwd.equals(pwd2)) {
			out.println("<script>");
			out.println("alert('새 비밀번호와 비밀번호 확인이 일치하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
			
		 } else {
			
			int result = dao.updatePwd(pwd, id, oldpwd);
			System.out.println(result);
			
			
				out.println("<script>");
				out.println("alert('비밀번호가 변경되었습니다.')");
				out.println("location.href='goLogin.do'");
				out.println("</script>");

		 }
		
		return null;
	
	
		
	}

}

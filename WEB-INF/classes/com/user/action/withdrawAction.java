package com.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.controller.Action;
import com.user.controller.ActionForward;
import com.user.model.UserDAO;

public class withdrawAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		UserDAO dao  = UserDAO.getInstance();
		
		String id = request.getParameter("id");
		System.out.println(id);
		int result = dao.deleteUser(id);
		System.out.println(result);

		
		HttpSession session = request.getSession(true);
        session.invalidate();

			
			ActionForward forward = new ActionForward(); 
			forward.setRedirect(false);
			forward.setPath("goIndex.do");


		return forward;

	
		
	}

}

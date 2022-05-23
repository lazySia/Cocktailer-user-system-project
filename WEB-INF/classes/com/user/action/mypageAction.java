package com.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.controller.Action;
import com.user.controller.ActionForward;
import com.user.model.UserDAO;
import com.user.model.UserDTO;

public class mypageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		UserDAO dao  = UserDAO.getInstance();
		
		
		String id = request.getParameter("id");
		System.out.println(id);
		List<UserDTO> list = dao.getUser(id);
		
		System.out.println(list);

        
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward(); 
		forward.setRedirect(false);
		forward.setPath("user/mypage.jsp");
		
		return forward;
			
	}

}

package com.user.action;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.controller.Action;
import com.user.controller.ActionForward;


public class logoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession(true);
        session.invalidate();
		
		ActionForward forward = new ActionForward(); 
		forward.setRedirect(false);
		forward.setPath("user/login.jsp");
//		
		return forward;
		
		
		
	}

}

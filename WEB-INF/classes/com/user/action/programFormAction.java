package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.controller.Action;
import com.user.controller.ActionForward;
import com.user.model.ProgramDAO;
import com.user.model.ProgramDTO;

public class programFormAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		
		ProgramDAO dao  = ProgramDAO.getInstance();
		ProgramDTO dto = new ProgramDTO();
		
		dto.setId(request.getParameter("id"));
		String pname = request.getParameter("pname");
		if ("a".equals(pname)) {
			dto.setPname("칵테일 클래스");
		} else if ("b".equals(pname)) {
			dto.setPname("럼 공장 투어");
		} else if ("c".equals(pname)) {
			dto.setPname("럼 시음 투어");
		}
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
		dto.setNumofpeople(Integer.parseInt(request.getParameter("numofpeople")));
		dto.setDate(request.getParameter("date"));

		
		int result = dao.InsertProgram(dto);
		System.out.println(result);
		
		PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('프로그램이 신청되었습니다.')");
			out.println("location.href='goIndex.do'");
			out.println("</script>");
		
		return null;
		
	
		
	}

}

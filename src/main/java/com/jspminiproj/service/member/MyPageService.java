package com.jspminiproj.service.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspminiproj.controller.MemberFactory;
import com.jspminiproj.dao.MemberCRUD;
import com.jspminiproj.dao.MemberDAO;
import com.jspminiproj.service.MemberService;
import com.jspminiproj.vo.Member;
import com.jspminiproj.vo.PointLog;

public class MyPageService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 멤버 정보 + pointlog정보
		String userId = request.getParameter("userId");
		
		System.out.println("조회할 멤버아이디: " + userId);
		
		MemberDAO dao = MemberCRUD.getInstance();
		
		try {
			Member memberInfo = dao.getMemberInfo(userId);
			List<PointLog> lst = dao.getPointLog(userId);
			
			request.setAttribute("memberInfo", memberInfo);
			request.setAttribute("pointLog", lst);
			
			request.getRequestDispatcher("myPage.jsp").forward(request, response);
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}

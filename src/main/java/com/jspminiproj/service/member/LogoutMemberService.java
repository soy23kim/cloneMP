package com.jspminiproj.service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspminiproj.controller.MemberFactory;
import com.jspminiproj.service.MemberService;

public class LogoutMemberService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("로그아웃 하자");
		
		HttpSession ses = request.getSession();
		
		ses.removeAttribute("loginUser");
		ses.invalidate();
		
		MemberFactory mf = MemberFactory.getInstance();
		mf.setRedirect(true);
		mf.setWhereToGo("../index.jsp");
		
		return mf;
	}

}

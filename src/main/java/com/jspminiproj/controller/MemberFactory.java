package com.jspminiproj.controller;

import com.jspminiproj.service.MemberService;
import com.jspminiproj.service.member.ConfirmMailCodeService;
import com.jspminiproj.service.member.DuplicateUserIdService;
import com.jspminiproj.service.member.LoginMemberService;
import com.jspminiproj.service.member.LogoutMemberService;
import com.jspminiproj.service.member.MyPageService;
import com.jspminiproj.service.member.RegisterMemberService;
import com.jspminiproj.service.member.SendMailService;

public class MemberFactory {
	
	private boolean isRedirect; //  redicrect를 할 것인지 말것인지 
	private String whereToGo;  // 어느 view단으로 이동할지
	
	private static MemberFactory instance = null;
	
	private MemberFactory() {}
	
	public static MemberFactory getInstance() {
		if (instance == null) {
			instance = new MemberFactory();
		}
		
		return instance;
	}
	
	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getWhereToGo() {
		return whereToGo;
	}

	public void setWhereToGo(String whereToGo) {
		this.whereToGo = whereToGo;
	}

	public MemberService getService(String command) {
		
		MemberService result = null;
		
		if (command.equals("/member/duplicateUserId.mem")) {
			result = new DuplicateUserIdService();
		} else if (command.equals("/member/registerMember.mem")) {
			result = new RegisterMemberService();
		} else if (command.equals("/member/sendMail.mem")){
			result = new SendMailService();
		} else if (command.equals("/member/confirmCode.mem")) {
			result = new ConfirmMailCodeService();
		} else if (command.equals("/member/login.mem")) {
			result = new LoginMemberService();
		} else if (command.equals("/member/logout.mem")) {
			result = new LogoutMemberService();
		} else if (command.equals("/member/myPage.mem")) {
			result = new MyPageService();
		}
		
		return result;
		
	}
	
	
	
}

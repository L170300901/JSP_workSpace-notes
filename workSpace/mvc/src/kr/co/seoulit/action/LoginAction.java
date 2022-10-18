package kr.co.seoulit.action;

import java.awt.*;
import java.util.*;

import kr.co.seoulit.model.MemberDAO;
import kr.co.seoulit.model.Member;
import kr.co.seoulit.view.*;

public class LoginAction implements Action{
	Frame next;
	public LoginAction(Frame next){
		this.next=next;
	}
	public Frame execute(Frame previousFrame){
		try{
			System.out.println("###00000@@@");
		MemberDAO dao=MemberDAO.getInstance();
		LoginForm loginform=(LoginForm)previousFrame;
		String id=loginform.id;
		String pw=loginform.pw;
		Member member=dao.selectMember(id);
		System.out.println(id+","+pw+","+member.id);
		
		if(member==null)
			throw new Exception("존재하지않는ID");
		else
			if(!pw.equals(member.getPw()))
			throw new Exception("버번오류");
		System.out.println("로그인성공");
		return next;
		}catch(Exception e){
			
			next=new ErrorForm(e.getMessage());
			return next;
		}
	}
}
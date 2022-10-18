package kr.co.seoulit.action;

import java.awt.*;
import java.util.*;

import kr.co.seoulit.model.MemberDAO;
import kr.co.seoulit.model.Member;
import kr.co.seoulit.view.*;

public class UpdateAction implements Action{
	Frame next;
	public UpdateAction(Frame next){
		this.next=next;
	}
	public Frame execute(Frame previousFrame){
		try{
		MemberDAO dao=MemberDAO.getInstance();
		Member member=((UpdateForm)previousFrame).member;
		dao.updateMember(member);	
		return next;
		}catch(Exception e){
			next=new ErrorForm(e.getMessage());
			return next;
		}
	}
}
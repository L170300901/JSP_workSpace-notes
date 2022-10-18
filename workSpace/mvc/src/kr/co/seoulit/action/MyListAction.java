 package kr.co.seoulit.action;

import java.awt.*;
import java.util.*;

import kr.co.seoulit.model.MemberDAO;
import kr.co.seoulit.model.Member;
import kr.co.seoulit.view.ListForm;
import kr.co.seoulit.view.ErrorForm;

public class MyListAction implements Action{
	Frame next;
	public MyListAction(Frame next){
		this.next=next;
	}
	public Frame execute(Frame previousFrame){
		try{
	  ListForm listform = new ListForm();
//		
//		MemberDAO dao=MemberDAO.getInstance();
//		ArrayList<Member> members=dao.selectMemberList();
//		listform.display(members);	
		
		return listform;
		}catch(Exception e){
			next=new ErrorForm(e.getMessage());
			return next;
		}
	}
}
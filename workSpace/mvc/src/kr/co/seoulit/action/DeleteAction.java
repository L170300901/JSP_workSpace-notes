package kr.co.seoulit.action;

import java.awt.*;
import java.util.*;

import kr.co.seoulit.model.MemberDAO;
import kr.co.seoulit.model.Member;
import kr.co.seoulit.view.*;

public class DeleteAction implements Action{
	Frame next;
	public DeleteAction(Frame next){
		this.next=next;
	}
	public Frame execute(Frame previousFrame){
		try{
		MemberDAO dao=MemberDAO.getInstance();
		
		
		String id=((ListForm)previousFrame).selectedId;
		dao.deleteMember(id);	
		return next;
		}catch(Exception e){
			next=new ErrorForm(e.getMessage());
			return next;
		}
	}
}
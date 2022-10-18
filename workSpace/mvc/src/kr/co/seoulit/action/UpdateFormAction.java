package kr.co.seoulit.action;

import java.awt.*;
import java.util.*;

import kr.co.seoulit.model.MemberDAO;
import kr.co.seoulit.model.Member;
import kr.co.seoulit.view.*;

public class UpdateFormAction implements Action{
	Frame next;
	public UpdateFormAction(Frame next){
		this.next=next;
	}
	public Frame execute(Frame previousFrame){
		try{
		MemberDAO dao=MemberDAO.getInstance();
		System.out.println("여기는 UpdateFormAction");
		String id=((ListForm)previousFrame).selectedId;
		System.out.println(id);
		Member member=dao.selectMember(id);
		((UpdateForm)next).display(member);		
		return next;
		}catch(Exception e){
			System.out.println("업데이트문 오류 발생="+e);
			
			//next=new ErrorForm(e.getMessage());
			next=new ErrorForm("----- id를 선택하지 않으셔서 수정을 할수 없습니다 만약 선택 하셨는데 안되시면 시스템 오류 입니다 (run하신걸 종료하고 다시 run해주세요)  -----");
			System.out.println(next);
			return next;
		}
	}
}
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
		System.out.println("����� UpdateFormAction");
		String id=((ListForm)previousFrame).selectedId;
		System.out.println(id);
		Member member=dao.selectMember(id);
		((UpdateForm)next).display(member);		
		return next;
		}catch(Exception e){
			System.out.println("������Ʈ�� ���� �߻�="+e);
			
			//next=new ErrorForm(e.getMessage());
			next=new ErrorForm("----- id�� �������� �����ż� ������ �Ҽ� �����ϴ� ���� ���� �ϼ̴µ� �ȵǽø� �ý��� ���� �Դϴ� (run�ϽŰ� �����ϰ� �ٽ� run���ּ���)  -----");
			System.out.println(next);
			return next;
		}
	}
}
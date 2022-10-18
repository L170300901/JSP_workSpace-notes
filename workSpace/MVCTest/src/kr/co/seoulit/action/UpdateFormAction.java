package kr.co.seoulit.action;

import java.awt.*;
import java.util.*;

import kr.co.seoulit.model.MemberDAO;
import kr.co.seoulit.model.Member;
import kr.co.seoulit.view.*;

public class UpdateFormAction implements Action {
	Frame next;

	public Frame execute(Frame previousFrame) {
		try {
			System.out.println("����� UpdateFormAction");
			UpdateForm uf = new UpdateForm();
			
			MemberDAO dao = MemberDAO.getInstance();

			String id = ((ListForm) previousFrame).selectedId;
			System.out.println(id + "���õ�");
			Member member = dao.selectMember(id);
			uf.display(member);
			return uf;
		} catch (Exception e) {
			System.out.println("������Ʈ�� ���� �߻�=" + e);

			// next=new ErrorForm(e.getMessage());
			next = new ErrorForm("----- id�� �������� �����ż� ������ �Ҽ� �����ϴ�  -----");
			System.out.println(next);
			return next;
		}
	}
}
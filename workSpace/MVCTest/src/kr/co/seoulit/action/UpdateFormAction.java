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
			System.out.println("여기는 UpdateFormAction");
			UpdateForm uf = new UpdateForm();
			
			MemberDAO dao = MemberDAO.getInstance();

			String id = ((ListForm) previousFrame).selectedId;
			System.out.println(id + "선택됨");
			Member member = dao.selectMember(id);
			uf.display(member);
			return uf;
		} catch (Exception e) {
			System.out.println("업데이트문 오류 발생=" + e);

			// next=new ErrorForm(e.getMessage());
			next = new ErrorForm("----- id를 선택하지 않으셔서 수정을 할수 없습니다  -----");
			System.out.println(next);
			return next;
		}
	}
}
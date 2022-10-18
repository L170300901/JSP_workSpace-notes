package kr.co.seoulit.action;

import java.awt.*;
import java.util.*;

import kr.co.seoulit.model.MemberDAO;
import kr.co.seoulit.model.Member;
import kr.co.seoulit.view.ListForm;
import kr.co.seoulit.view.ErrorForm;

public class ListAction implements Action {
	Frame next;

	public Frame execute(Frame previousFrame) {
		try {
			ListForm lf = new ListForm();
			MemberDAO dao = MemberDAO.getInstance();
			ArrayList<Member> members = dao.selectMemberList();
			lf.display(members);
			return lf;
		} catch (Exception e) {
			next = new ErrorForm(e.getMessage());
			return next;
		}
	}
}
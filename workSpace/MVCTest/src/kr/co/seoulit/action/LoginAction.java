package kr.co.seoulit.action;

import java.awt.*;
import java.util.*;

import kr.co.seoulit.model.MemberDAO;
import kr.co.seoulit.model.Member;
import kr.co.seoulit.view.*;

public class LoginAction implements Action {
	Frame next;

	public Frame execute(Frame previousFrame) {
		try {
			MenuForm mf = new MenuForm();

			MemberDAO dao = MemberDAO.getInstance();
			LoginForm loginform = (LoginForm) previousFrame;
			String id = loginform.id;
			String pw = loginform.pw;
			Member member = dao.selectMember(id);
			System.out.println(id + "," + pw + "," + member.id);

			if (member == null)
				throw new Exception("���������ʴ�ID");
			else if (!pw.equals(member.getPw()))
				throw new Exception("��������");
			System.out.println("�α��μ���");
			return mf;
		} catch (Exception e) {

			next = new ErrorForm(e.getMessage());
			return next;
		}
	}
}
package kr.co.seoulit.action;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import kr.co.seoulit.model.MemberDAO;
import kr.co.seoulit.model.Member;
import kr.co.seoulit.view.*;

public class JoinAction implements Action {
	Frame next;

	public Frame execute(Frame previousFrame) {
		try {
			MenuForm mf =new MenuForm();
			MemberDAO dao = MemberDAO.getInstance();

			System.out.println("@@@previousFrame====" + previousFrame);
			Member member = ((JoinForm) previousFrame).member;
			dao.insertMember(member);

			Frame f = new Frame();
			Label la1 = new Label("축하합니다! 회원 가입 되었습니다 !!");
			f.add(la1);
			f.setBounds(500, 200, 200, 200);
			f.setVisible(true);
			f.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					f.dispose();
				}
			});

			return mf;
		} catch (Exception e) {
			next = new ErrorForm(e.getMessage());
			return next;
		}
	}
}
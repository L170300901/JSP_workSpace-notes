package kr.co.seoulit.view;

import java.awt.*;
import java.awt.event.*;
import kr.co.seoulit.controller.MemberFC;
import kr.co.seoulit.model.Member;

public class Home extends Frame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Label la1;
	Button b1, b2, b3;

	public Home() {
		setLayout(new GridLayout(4, 1));

		la1 = new Label("로그인 되었습니다");
		b1 = new Button("내 정보 보기");
		b2 = new Button("회원 리스트");
		b3 = new Button("로그아웃");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		add(la1);
		add(b1);
		add(b2);
		add(b3);

	}

	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if (obj == b1)
			MemberFC.service("myList", null);
		else if (obj == b2)
			MemberFC.service("list", null);
		else
			MemberFC.service("menu", null);
		terminate();
	}

	void terminate() {
		dispose();
		setVisible(false);
	}
}
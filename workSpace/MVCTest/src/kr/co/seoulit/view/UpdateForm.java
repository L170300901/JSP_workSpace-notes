package kr.co.seoulit.view;

import java.awt.*;
import java.awt.event.*;
import kr.co.seoulit.model.*;
import kr.co.seoulit.controller.MemberFC;

public class UpdateForm extends Frame implements ActionListener {
	private TextField tf1, tf2, tf3, tf4;
	private Button b1, b2;
	public Member member;

	public UpdateForm() {
		tf1 = new TextField();
		tf2 = new TextField();
		tf3 = new TextField();
		tf4 = new TextField();
		b1 = new Button("수정");
		b2 = new Button("취소");
		setLayout(new GridLayout(6, 1));
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(b1);
		add(b2);
		tf1.setEnabled(false);
		b1.addActionListener(this);
		b2.addActionListener(this);

	}

	public void display(Member member) {
		tf1.setText(member.getId());
		tf2.setText(member.getPw());
		tf3.setText(member.getAddr());
		tf4.setText(member.getTel());
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			member = new Member();
			member.setId(tf1.getText());
			member.setPw(tf2.getText());
			member.setAddr(tf3.getText());
			member.setTel(tf4.getText());
			setVisible(false);
			MemberFC.service("update", this);
		}
		else {
			MemberFC.service("menu", null);
		}
	}
}
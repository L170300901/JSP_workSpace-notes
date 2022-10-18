package kr.co.seoulit.view;

import java.awt.*;
import java.awt.event.*;
import kr.co.seoulit.model.*;
import kr.co.seoulit.controller.MemberFC;

public class UpdateForm extends Frame implements ActionListener {
	private TextField tf1, tf2, tf3, tf4;
	private Button b;
	public Member member;

	public UpdateForm() {
		tf1 = new TextField();
		tf2 = new TextField();
		tf3 = new TextField();
		tf4 = new TextField();
		b = new Button("¼öÁ¤");
		setLayout(new GridLayout(5, 1));
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(b);
		b.addActionListener(this);

	}

	public void display(Member member) {
		tf1.setText(member.getId());
		tf2.setText(member.getPw());
		tf3.setText(member.getAddr());
		tf4.setText(member.getTel());
	}

	public void actionPerformed(ActionEvent ae) {
		member = new Member();
		member.setId(tf1.getText());
		member.setPw(tf2.getText());
		member.setAddr(tf3.getText());
		member.setTel(tf4.getText());
		setVisible(false);
		MemberFC.service("update", this);
	}
}
package kr.co.seoulit.view;

import java.awt.*;
import java.awt.event.*;
import kr.co.seoulit.controller.MemberFC;
import kr.co.seoulit.model.Member;

public class LoginForm extends Frame implements ActionListener {
	private TextField tf1, tf2;
	private Button b1, b2, b3;
	public String id, pw;
	public LoginForm previousFrame;

	public LoginForm() {
		tf1 = new TextField();
		tf2 = new TextField();
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(2, 1));
		p1.add(tf1);
		p1.add(tf2);
		add(p1);
		Panel p2 = new Panel();
		b1 = new Button("���");
		b2 = new Button("�α���");
		// b3 = new Button("�޴���");

		p2.add(b1);
		p2.add(b2);
		// p2.add(b3);
		add(p2, "South");
		b1.addActionListener(this);
		b2.addActionListener(this);
		// b3.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		String cmd = "";
		switch (ae.getActionCommand()) {
		case "���":
			cmd = "menu";
			break;
		case "�α���":
			id = tf1.getText().trim();
			pw = tf2.getText().trim();
			cmd = "login";
			// MemberFC.service("login",this);
			break;
//		case "�޴���":
//			cmd = "menu";
//			break;
		}
		tf1.setText("");
		tf2.setText("");
		// System.out.println("$$"+this);
		MemberFC.service(cmd, this);
	}
}
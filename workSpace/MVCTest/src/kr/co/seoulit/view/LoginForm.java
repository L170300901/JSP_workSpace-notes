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
//		tf1 = new TextField();
//		tf2 = new TextField();
//		Panel p1 = new Panel();
//		p1.setLayout(new GridLayout(2, 1));
//		p1.add(tf1);
//		p1.add(tf2);
//		add(p1);
//		Panel p2 = new Panel();
//		b1 = new Button("취소");
//		b2 = new Button("로그인");
//		// b3 = new Button("메뉴폼");
//
//		p2.add(b1);
//		p2.add(b2);
//		// p2.add(b3);
//		add(p2, "South");
//		b1.addActionListener(this);
//		b2.addActionListener(this);
//		// b3.addActionListener(this);
		// North - 윗쪽 문구한 줄
		setLayout(new BorderLayout());
		Label lMessage = new Label("로그인 하세요");
		this.add(BorderLayout.NORTH, lMessage);

		Panel panel1 = new Panel();
		panel1.setLayout(new BorderLayout());
		this.add(panel1);

		// 내부 왼쪽 TextField 2개
		Panel panel11 = new Panel();
		panel11.setLayout(new GridLayout(2, 1));
		panel1.add(BorderLayout.WEST, panel11);

		Panel panel11up = new Panel();
		tf1 = new TextField("", 20);
		panel11up.add(tf1);
		panel11.add(panel11up);

		Panel panel11down = new Panel();
		tf2 = new TextField("", 20);
		panel11down.add(tf2);
		panel11.add(panel11down);

		// 내부 오른쪽 check + button
		Panel panel12 = new Panel();
		panel12.setLayout(new GridLayout(2, 1));
		panel1.add(BorderLayout.CENTER, panel12);

		Panel panel12up = new Panel();
		Checkbox cb1 = new Checkbox("ID저장");
		panel12up.add(cb1);
		panel12.add(panel12up);

		Panel panel12down = new Panel();
		Button blogin = new Button("로그인");
		panel12down.add(blogin);
		panel12.add(panel12down);

	}

	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		String cmd = "";
		switch (ae.getActionCommand()) {
		case "취소":
			cmd = "menu";
			break;
		case "로그인":
			id = tf1.getText().trim();
			pw = tf2.getText().trim();
			cmd = "login";
			// MemberFC.service("login",this);
			break;
//		case "메뉴폼":
//			cmd = "menu";
//			break;
		}
		tf1.setText("");
		tf2.setText("");
		// System.out.println("$$"+this);
		MemberFC.service(cmd, this);
	}
}
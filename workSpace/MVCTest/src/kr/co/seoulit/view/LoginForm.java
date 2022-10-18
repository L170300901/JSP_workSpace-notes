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
//		b1 = new Button("���");
//		b2 = new Button("�α���");
//		// b3 = new Button("�޴���");
//
//		p2.add(b1);
//		p2.add(b2);
//		// p2.add(b3);
//		add(p2, "South");
//		b1.addActionListener(this);
//		b2.addActionListener(this);
//		// b3.addActionListener(this);
		// North - ���� ������ ��
		setLayout(new BorderLayout());
		Label lMessage = new Label("�α��� �ϼ���");
		this.add(BorderLayout.NORTH, lMessage);

		Panel panel1 = new Panel();
		panel1.setLayout(new BorderLayout());
		this.add(panel1);

		// ���� ���� TextField 2��
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

		// ���� ������ check + button
		Panel panel12 = new Panel();
		panel12.setLayout(new GridLayout(2, 1));
		panel1.add(BorderLayout.CENTER, panel12);

		Panel panel12up = new Panel();
		Checkbox cb1 = new Checkbox("ID����");
		panel12up.add(cb1);
		panel12.add(panel12up);

		Panel panel12down = new Panel();
		Button blogin = new Button("�α���");
		panel12down.add(blogin);
		panel12.add(panel12down);

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
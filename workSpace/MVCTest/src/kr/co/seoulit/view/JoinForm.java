package kr.co.seoulit.view;

import java.awt.*;
import java.awt.event.*;
import kr.co.seoulit.controller.MemberFC;
import kr.co.seoulit.model.Member;

public class JoinForm extends Frame implements ActionListener {
	private TextField tf1, tf2, tf3, tf4;
	private Button b;
	public Member member;

	public JoinForm() {
		tf1 = new TextField();
		tf2 = new TextField();
		tf3 = new TextField();
		tf4 = new TextField();
		b = new Button("����");
		setLayout(new GridLayout(5, 1));
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(b);
		b.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae) {

		// joinForm �ݱ�
		setVisible(false);

		// merber�� ID,PW,ADDR,TEL���
		member = new Member();
		member.setId(tf1.getText());
		member.setPw(tf2.getText());
		member.setAddr(tf3.getText());
		member.setTel(tf4.getText());

		// joinForm�� tf�� �ٽ� ��ĭ���� ������ֱ�
//		tf1.setText("");
//		tf2.setText("");
//		tf3.setText("");
//		tf4.setText("");

		// ��Ʈ�ѷ��� ��û
		MemberFC.service("join", this);
	}
}
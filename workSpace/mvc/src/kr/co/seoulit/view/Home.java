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

		la1 = new Label("�α��� �Ǿ����ϴ�");
		b1 = new Button("�� ���� ����");
		b2 = new Button("ȸ�� ����Ʈ");
		b3 = new Button("�α׾ƿ�");

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
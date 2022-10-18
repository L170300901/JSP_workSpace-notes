package kr.co.seoulit.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import kr.co.seoulit.controller.MemberFC;
import kr.co.seoulit.model.Member;

public class ListForm extends Frame implements ActionListener {
	java.awt.List list;
	Button b1, b2, b3;
	public String selectedId;

	public ListForm() {
		list = new java.awt.List();
		add(list, "Center");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		b1 = new Button("����");
		b2 = new Button("����");
		b3 = new Button("�޴���");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		Panel p = new Panel();
		p.add(b1);
		p.add(b2);
		p.add(b3);
		add(p, "South");
	}

	public void actionPerformed(ActionEvent ae) {
		selectedId = list.getSelectedItem();
		setVisible(false);
		if (ae.getSource() == b1) {

			MemberFC.service("update-form", this);

		}

		else if (ae.getSource() == b2)
			MemberFC.service("delete", this);
		else
			MemberFC.service("menu", null);
	}

	public void display(ArrayList<Member> members) {
		list.removeAll();
		for (Member member : members)
			list.add(member.getId());
	}
}
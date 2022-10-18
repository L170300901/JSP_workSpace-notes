package kr.co.seoulit.view;

import java.awt.*;
import java.awt.event.*;
import kr.co.seoulit.controller.MemberFC;

public class MenuForm extends Frame implements ActionListener {
	
	
	// Frame Ŭ������ ��� (view�� ���� ������ ����ϰڴ� ) 
	// ActionListener �������̽��� ���� ( �̺�Ʈ ó���� �ϰڴ� ) > �������̵� [actionPerformed(){}]


	// [�������]�� ����ؾ� �����Ӱ� ȣ���ؼ� ����� �� �ִ� 
	Label la1;
	Button b1, b2;

	public MenuForm() {
		
		System.out.println("------1�� -1 ����� menu form �Դϴ�");
		setLayout(new GridLayout(3, 1));

		la1 = new Label("�α��� ���ּ���");
		b1 = new Button("ȸ�� ����");
		b2 = new Button("�α���");

		//�̺�Ʈ�� ���
		b1.addActionListener(this);
		b2.addActionListener(this);

		//��ư�� ����
		add(la1);
		add(b1);
		add(b2);
		
	}

	//ActionListener�� �߻� �޼��� actionPerformed()�� �������̵�
	//b1�̳� b2�� �������� �߻��ϴ� ��ȭ
	public void actionPerformed(ActionEvent e) {
		
		
		System.out.println("e.getActionCommand()������ ======="+e.getActionCommand());
		if (e.getActionCommand() == "ȸ�� ����") {
			System.out.println("@@ 1. e.getActionCommand() ���� @@");
		}
		System.out.println("e.getSource() ������ ======"+e.getSource());
		if (e.getSource() == b1) {
			System.out.println("@@ 2. e.getSourse() ���� @@");
			
		}
		

		
	}
}
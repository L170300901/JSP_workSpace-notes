package kr.co.seoulit.view;

import java.awt.*;
import java.awt.event.*;
import kr.co.seoulit.controller.MemberFC;

public class MenuForm extends Frame implements ActionListener {
	
	
	// Frame 클래스를 상속 (view를 위한 도구를 사용하겠다 ) 
	// ActionListener 인터페이스를 구현 ( 이벤트 처리를 하겠다 ) > 오버라이딩 [actionPerformed(){}]


	// [멤버변수]로 사용해야 자유롭게 호출해서 사용할 수 있다 
	Label la1;
	Button b1, b2;

	public MenuForm() {
		
		System.out.println("------1번 -1 여기는 menu form 입니다");
		setLayout(new GridLayout(3, 1));

		la1 = new Label("로그인 해주세요");
		b1 = new Button("회원 가입");
		b2 = new Button("로그인");

		//이벤트를 등록
		b1.addActionListener(this);
		b2.addActionListener(this);

		//버튼을 붙임
		add(la1);
		add(b1);
		add(b2);
		
	}

	//ActionListener의 추상 메서드 actionPerformed()를 오버라이딩
	//b1이나 b2를 눌렀을때 발생하는 교화
	public void actionPerformed(ActionEvent e) {
		
		
		System.out.println("e.getActionCommand()눌러짐 ======="+e.getActionCommand());
		if (e.getActionCommand() == "회원 가입") {
			System.out.println("@@ 1. e.getActionCommand() 사용법 @@");
		}
		System.out.println("e.getSource() 눌러짐 ======"+e.getSource());
		if (e.getSource() == b1) {
			System.out.println("@@ 2. e.getSourse() 사용법 @@");
			
		}
		

		
	}
}
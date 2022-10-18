package kr.co.seoulit.view;
import java.awt.*;
import java.awt.event.*;
import kr.co.seoulit.controller.MemberFC;

public class MenuForm extends Frame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Label la1;
	Button b1, b2, b3;
	
	public MenuForm(){
		setLayout(new GridLayout(4,1));

		la1=new Label("ȸ������");
		b1=new Button("����");
		b2=new Button("����Ʈ");
		b3=new Button("�α���");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		add(la1);add(b1);add(b2);add(b3);
		addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					terminate();
					System.exit(1);
				}
			}
		);
	}
	public void actionPerformed(ActionEvent ae){
		Object obj=ae.getSource();
		if(obj==b1)
			MemberFC.service("join-form",null);
		else if(obj==b2)
			MemberFC.service("list",null);
		else
			MemberFC.service("login-form",null);	
		terminate();
	}	
	void terminate(){
		dispose();
		setVisible(false);
	}
}
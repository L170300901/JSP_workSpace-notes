package kr.co.seoulit.view;
import java.awt.*;
import java.awt.event.*;
import kr.co.seoulit.controller.MemberFC;
import kr.co.seoulit.model.Member;
public class ErrorForm extends Frame implements ActionListener{

	private Button b;
	public ErrorForm(String errmsg){
		add(new Label(errmsg));
		b=new Button("¸Þ´ºÆû");
		b.addActionListener(this);
		add(b,"South");
	}
	public void actionPerformed(ActionEvent ae){
		setVisible(false);
		dispose();
		MemberFC.service("menu",null);
	}
}
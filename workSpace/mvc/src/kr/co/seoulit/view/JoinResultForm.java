package kr.co.seoulit.view;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JoinResultForm {

	JoinResultForm() {

		Frame f = new Frame();
		Label la1 = new Label("�����մϴ�! ȸ�� ���� �Ǿ����ϴ� !!");
		f.add(la1);
		f.setBounds(500, 200, 200, 200);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
	}
}

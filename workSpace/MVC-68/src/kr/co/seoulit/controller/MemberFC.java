package kr.co.seoulit.controller;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.seoulit.mapper.ActionMapper;
import kr.co.seoulit.action.Action;

public class MemberFC{
	public static void service(String cmd, Frame previousFrame){
		
		System.out.println("MemberFC");
		
		
		Action action=ActionMapper.getInstance().getAction(cmd);
		Frame next=action.execute(previousFrame);
		
		//ȭ�� ��ġ ���� 
		next.setBounds(200, 200, 300, 300);
		next.setVisible(true);
		
		//â�ݱ� 
		next.addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(1);
					}
				}
			);
	}
}

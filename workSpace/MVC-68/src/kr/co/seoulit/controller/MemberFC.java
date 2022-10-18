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
		
		//화면 위치 설정 
		next.setBounds(200, 200, 300, 300);
		next.setVisible(true);
		
		//창닫기 
		next.addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(1);
					}
				}
			);
	}
}

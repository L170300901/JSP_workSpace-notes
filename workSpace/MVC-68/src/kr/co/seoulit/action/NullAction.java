package kr.co.seoulit.action;

import java.awt.*;

public class NullAction implements Action{
	Frame next;
	public NullAction(Frame next){
		System.out.println("------1번 -2 여기는 NullAction 입니다");
		
		this.next=next;
		
		System.out.println("------1번 -2 -1 next ==="+this.next);
	}
	public Frame execute(Frame previousFrame){
		System.out.println("next=="+next);
		return next;
	}
}
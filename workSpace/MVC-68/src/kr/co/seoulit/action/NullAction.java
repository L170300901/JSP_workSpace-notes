package kr.co.seoulit.action;

import java.awt.*;

public class NullAction implements Action{
	Frame next;
	public NullAction(Frame next){
		System.out.println("------1�� -2 ����� NullAction �Դϴ�");
		
		this.next=next;
		
		System.out.println("------1�� -2 -1 next ==="+this.next);
	}
	public Frame execute(Frame previousFrame){
		System.out.println("next=="+next);
		return next;
	}
}
package kr.co.seoulit.action;

import java.awt.*;

public class NullAction implements Action{
	Frame next;
	public NullAction(Frame next){
		this.next=next;
	}
	public Frame execute(Frame previousFrame){
		System.out.println("next=="+next);
		return next;
	}
}
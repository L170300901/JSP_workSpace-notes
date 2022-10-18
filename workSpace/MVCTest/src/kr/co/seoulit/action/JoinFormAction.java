package kr.co.seoulit.action;

import java.awt.Frame;

import kr.co.seoulit.view.JoinForm;

public class JoinFormAction implements Action{
	
	public Frame execute(Frame previousFrame){
		return new JoinForm();
	}

}
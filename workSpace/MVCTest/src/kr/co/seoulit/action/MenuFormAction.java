package kr.co.seoulit.action;

import java.awt.Frame;

import kr.co.seoulit.view.MenuForm;

public class MenuFormAction implements Action{
	
	public Frame execute(Frame previousFrame){
		return new MenuForm();
	}
}



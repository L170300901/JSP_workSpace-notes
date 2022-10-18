package kr.co.seoulit.action;
import java.awt.Frame;

import kr.co.seoulit.view.LoginForm;

public class LoginFormAction implements Action{
	public Frame execute(Frame previousFrame){
		return new LoginForm();
	}

}







package kr.co.seoulit.mapper;

import java.util.*;
import kr.co.seoulit.action.*;
import kr.co.seoulit.view.*;

public class ActionMapper {
	
	//private static final boolean True = false;

	private static HashMap<String, Action> commands;

	private static ActionMapper instance;

	private ActionMapper() {
		System.out.println("@@");
	}

	static {
		

		
		System.out.println("@@��ü�� �����ɶ�  static block ����@@ ");
		MenuForm mf = new MenuForm();
		commands = new HashMap<String, Action>();
		commands.put("join-form", new NullAction(new JoinForm()));
		commands.put("join", new JoinAction(mf));
		commands.put("update-form", new UpdateFormAction(new UpdateForm()));
		commands.put("cancel", new NullAction(mf));
		commands.put("menu", new NullAction(mf));
		commands.put("list", new ListAction(new ListForm()));
		commands.put("update", new UpdateAction(mf));
		commands.put("delete", new DeleteAction(mf));
		commands.put("login-form", new NullAction(new LoginForm()));
		commands.put("login", new LoginAction(new Home()));
		commands.put("home", new NullAction(new Home()));
		commands.put("myList", new MyListAction(new Home()));

		System.out.println("static �������");
	}

	public static ActionMapper getInstance() {
		System.out.println("@@@ ");
		if (instance == null) {
			System.out.println("����� action maper istance ");
			instance = new ActionMapper();
		}
		return instance;
	}

	public Action getAction(String cmd) {
		if (cmd == null) {
			System.out.println("@");
		cmd = "menu";
		}
		if (commands.containsKey(cmd.toLowerCase())) {
			System.out.println("###00000");
			return commands.get(cmd.toLowerCase());
		}
		//runtimeexception�� unchecked�̱� ������ throw�� try catch ���ص���
		else {
			System.out.println("###111111");
			throw new RuntimeException("�߸��� ��ɾ� : " + cmd);
		}
	}
}

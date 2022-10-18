package kr.co.seoulit.mapper;

import java.util.*;
import kr.co.seoulit.action.*;
import kr.co.seoulit.view.*;

public class ActionMapper {

	private static HashMap<String, Action> commands;
	private static ActionMapper instance;

	private ActionMapper() {
		System.out.println("------4�� ");
	}

	static {

		System.out.println("------1�� ");
		// System.out.println("@@Ŭ������ �ε� �ɶ� �ڵ����� static block ����@@ ");

		MenuForm mf = new MenuForm();
		commands = new HashMap<String, Action>();

		// Map �ȿ� �� �ֱ� commands.put(key,value);
		commands.put("menu", new NullAction(mf));
		
		
	}

	public static ActionMapper getInstance() {
		System.out.println("------2�� ");
		if (instance == null) {
			System.out.println("------3�� ");
			instance = new ActionMapper();
		}
		return instance;
	}

	public Action getAction(String cmd) {
		if (cmd == null) {

			System.out.println("------5�� ");
			cmd = "menu";
		}
		
		// Map �ȿ� Ư�� Key, Value ������� Ȯ��
		if (commands.containsKey(cmd)) {

			System.out.println("------6�� ");

			// Map ���� ��(Action) �������� commands.get(key);
			return commands.get(cmd);
		} else {
			throw new RuntimeException("�߸��� ��ɾ� : " + cmd);
		}
	}
}

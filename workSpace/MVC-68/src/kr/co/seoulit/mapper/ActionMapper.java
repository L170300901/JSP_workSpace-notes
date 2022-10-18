package kr.co.seoulit.mapper;

import java.util.*;
import kr.co.seoulit.action.*;
import kr.co.seoulit.view.*;

public class ActionMapper {

	private static HashMap<String, Action> commands;
	private static ActionMapper instance;

	private ActionMapper() {
		System.out.println("------4번 ");
	}

	static {

		System.out.println("------1번 ");
		// System.out.println("@@클래스가 로드 될때 자동으로 static block 실행@@ ");

		MenuForm mf = new MenuForm();
		commands = new HashMap<String, Action>();

		// Map 안에 값 넣기 commands.put(key,value);
		commands.put("menu", new NullAction(mf));
		
		
	}

	public static ActionMapper getInstance() {
		System.out.println("------2번 ");
		if (instance == null) {
			System.out.println("------3번 ");
			instance = new ActionMapper();
		}
		return instance;
	}

	public Action getAction(String cmd) {
		if (cmd == null) {

			System.out.println("------5번 ");
			cmd = "menu";
		}
		
		// Map 안에 특정 Key, Value 들었는지 확인
		if (commands.containsKey(cmd)) {

			System.out.println("------6번 ");

			// Map 안의 값(Action) 가져오기 commands.get(key);
			return commands.get(cmd);
		} else {
			throw new RuntimeException("잘못된 명령어 : " + cmd);
		}
	}
}

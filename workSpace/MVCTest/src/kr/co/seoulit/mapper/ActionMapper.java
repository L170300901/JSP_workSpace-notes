package kr.co.seoulit.mapper;

import java.util.*;
import kr.co.seoulit.action.*;
import kr.co.seoulit.view.*;

public class ActionMapper {
	private static HashMap<String,Action> commands;

	private static ActionMapper instance;
	private ActionMapper(){}

	static{
		
		commands=new HashMap<String,Action>();
		//�Ŵ�â�� �� 
		commands.put("menu",new MenuFormAction());
		
		//����Ʈ�� ������ ����/����/�Ŵ���
		commands.put("list",new ListAction());
		commands.put("update-form", new UpdateFormAction());
		commands.put("update", new UpdateAction());
		commands.put("delete", new DeleteAction());
		commands.put("cancel", new MenuFormAction());
		
		//ȸ������
		commands.put("join-form",new JoinFormAction());
		commands.put("join", new JoinAction());
		
		//�α���
		commands.put("login-form", new LoginFormAction());
		commands.put("login", new LoginAction());


	}

	public static ActionMapper getInstance() {
		if(instance==null)
			instance=new ActionMapper();
		return instance;
	}

	public Action getAction(String cmd){
		if(cmd==null)
			cmd="menu";
		if(commands.containsKey(cmd.toLowerCase())) {
			return commands.get(cmd.toLowerCase());
		}
		else
			throw new RuntimeException("�߸��� ��ɾ� : "+cmd);
	}
}

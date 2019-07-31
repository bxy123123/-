package com.cc.controller.supermanager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.entity.User;
import com.cc.service.UserService;
import com.cc.util.NoteResult;

@Controller
public class AddUserController {

	
	@Resource
	private UserService us;
	
	/**
	 * ��ӽ�ɫ
	 * @param userphone
	 * @param username
	 * @param userage
	 * @param usersex
	 * @param user_role
	 * @param user_IDCard
	 * @return
	 */
	@RequestMapping("/AddUser.do")
	@ResponseBody
	public NoteResult AddUser(String userphone,String username,Integer userage,char usersex,String user_role,String user_IDCard){
		User user=new User();
		user.setUser_age(userage);
		user.setUser_IDCard(user_IDCard);
		user.setUser_name(username);
		user.setUser_phone(userphone);
		user.setUser_role(user_role);
		user.setUser_sex(usersex);
		user.setUser_status(0);
		if(user_role.equals("��Ա����Ա")){
			user.setRole_id(1);
		}else if(user_role.equals("���ع���Ա")){
			user.setRole_id(2);
		}else if(user_role.equals("רҵ����Ա")){
			user.setRole_id(3);
		}else if(user_role.equals("��֯����Ա")){
			user.setRole_id(4);
		}else if(user_role.equals("����Ա")){
			user.setRole_id(5);
		}else if(user_role.equals("�༶����Ա")){
			user.setRole_id(6);
		}
		NoteResult result=us.AddUser(user);
		return result;
	}
}

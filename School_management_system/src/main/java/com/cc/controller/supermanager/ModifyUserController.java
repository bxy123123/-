package com.cc.controller.supermanager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.entity.User;
import com.cc.service.UserService;
import com.cc.util.NoteResult;

@Controller
public class ModifyUserController {

	@Resource
	private UserService us;
	
	/**
	 * ��ɫ�༭(��ʾ������Ϣ�ڱ༭ҳ��)
	 * @param user_id
	 * @param req
	 * @return
	 */
	@RequestMapping("/ModifyUser.do")
	@ResponseBody
	public NoteResult ModifyUser(Integer user_id){
		System.out.println(user_id);
		NoteResult result=us.ModifyUser(user_id);
		return result;
	}
	/**
	 * �޸Ľ�ɫ״̬
	 * @param user_id
	 * @param req
	 * @return
	 */
	@RequestMapping("/updateStart.do")
	@ResponseBody
	public String updateStart(Integer id){
		us.updateStart(id);
		return "";
	}
	
	/**
	 * �޸Ľ�ɫ״̬
	 * @param user_id
	 * @param req
	 * @return
	 */
	@RequestMapping("/updateStop.do")
	@ResponseBody
	public String updateStop(Integer id){
		us.updateStop(id);
		return "";
	}
	
	/**
	 * ��ɫ�༭(�޸ĸ�����Ϣ)
	 * @param user_id
	 * @param userphone
	 * @param username
	 * @param userage
	 * @param usersex
	 * @param user_role
	 * @param user_IDCard
	 * @return
	 */
	@RequestMapping("/UpdateUser.do")
	@ResponseBody
	public NoteResult UpdateUser(Integer user_id,String userphone,String username,Integer userage,char usersex,String user_role,String user_IDCard){
		User user=new User();
		user.setUser_id(user_id);
		user.setUser_age(userage);
		user.setUser_IDCard(user_IDCard);
		user.setUser_name(username);
		user.setUser_phone(userphone);
		user.setUser_role(user_role);
		user.setUser_sex(usersex);
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
		NoteResult result=us.UpdateUser(user);
		return result;
	}
}

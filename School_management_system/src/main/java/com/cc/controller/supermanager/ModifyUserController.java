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
	 * 角色编辑(显示个人信息在编辑页面)
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
	 * 修改角色状态
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
	 * 修改角色状态
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
	 * 角色编辑(修改个人信息)
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
		if(user_role.equals("人员管理员")){
			user.setRole_id(1);
		}else if(user_role.equals("场地管理员")){
			user.setRole_id(2);
		}else if(user_role.equals("专业管理员")){
			user.setRole_id(3);
		}else if(user_role.equals("组织管理员")){
			user.setRole_id(4);
		}else if(user_role.equals("辅导员")){
			user.setRole_id(5);
		}else if(user_role.equals("班级管理员")){
			user.setRole_id(6);
		}
		NoteResult result=us.UpdateUser(user);
		return result;
	}
}

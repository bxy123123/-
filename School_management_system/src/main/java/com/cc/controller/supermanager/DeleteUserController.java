package com.cc.controller.supermanager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.service.UserService;
import com.cc.util.NoteResult;

@Controller
public class DeleteUserController {

	
	@Resource
	private UserService us;
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/DeleteUser.do")
	@ResponseBody
	public NoteResult DeleteUser(Integer user_id){
		NoteResult result=us.DeleteUser(user_id);
		return result;
	}
}

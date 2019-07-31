package com.cc.controller.myselfmanager;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.service.UserService;
import com.cc.util.NoteResult;
/**
 * 个人信息类
 * @author Administrator
 *
 */
@Controller
public class MyselfInfoController {

	@Resource
	private UserService us;
	
	/**
	 * 个人信息
	 * @return
	 */
	@RequestMapping("/MyselfInfo.do")
	@ResponseBody
	public NoteResult MyselfInfo(){
		NoteResult result=us.MyselfInfo();
		return result;
	}
}

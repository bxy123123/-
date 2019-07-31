package com.cc.controller.myselfmanager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.service.UserService;
import com.cc.util.NoteResult;

@Controller
public class UpdatePwdController {

	
	@Resource
	private UserService us;
	
	/**
	 * �޸�����
	 * @param user_id
	 * @param pwd
	 * @return
	 */
	@RequestMapping("/ModifyPwd.do")
	@ResponseBody
	public NoteResult ModifyPwd(String pwd){
		NoteResult result=us.ModifyPwd(pwd);
		return result;
	}
	
	/**
	 * ��ѯ����ȶ��Ƿ���ȷ
	 * @param user_id
	 * @param pwd
	 * @return
	 */
	@RequestMapping("/selectUserpwd.do")
	@ResponseBody
	public NoteResult selectUserpwd(String pwd){
		NoteResult result=us.selectUserpwd(pwd);
		return result;
	}
}

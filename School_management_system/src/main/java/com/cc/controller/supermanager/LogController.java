package com.cc.controller.supermanager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.service.LogService;
import com.cc.util.NoteResult;

@Controller
public class LogController {
	
	@Resource
	private LogService ls;

	/**
	 * 添加日志
	 * @param log
	 * @param name
	 * @param role
	 */
	@RequestMapping("/addLog.do")
	@ResponseBody
	public void addlog(String log,String name,String role){
		ls.addLogInformation(log,name,role);
	}
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/DeleteLog.do")
	@ResponseBody
	public NoteResult DeleteLog(Integer log_id){
		NoteResult result=ls.DeleteLog(log_id);
		return result;
	}
}

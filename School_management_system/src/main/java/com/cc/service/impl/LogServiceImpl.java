package com.cc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cc.dao.LogDao;
import com.cc.entity.Log;
import com.cc.service.LogService;
import com.cc.util.NoteResult;

@Service
public class LogServiceImpl implements LogService {

	@Resource
	private LogDao ld;
	
	public void addLogInformation(String log, String name, String role) {
		Log l = new Log();
		l.setLog_name(name);
		l.setLog_function(log);
		l.setLog_role(role);
		ld.addlogInformation(l);
		
	}

	public NoteResult DeleteLog(Integer user_id) {
		ld.DeleteLog(user_id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}

}

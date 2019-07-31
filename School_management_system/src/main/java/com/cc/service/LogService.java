package com.cc.service;

import com.cc.util.NoteResult;

public interface LogService {

	void addLogInformation(String log, String name, String role);

	NoteResult DeleteLog(Integer user_id);

}

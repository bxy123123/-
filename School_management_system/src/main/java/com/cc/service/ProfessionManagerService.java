package com.cc.service;

import com.cc.entity.Professional;
import com.cc.util.NoteResult;

public interface ProfessionManagerService {

	//添加专业信息
	NoteResult AddProfession(Professional p);

	//删除专业信息
	NoteResult DeleteProfession(Integer id);

	//根据Id查询专业信息
	NoteResult ShowProfession(Integer id);

	//修改专业信息
	NoteResult UpdateProfession(Professional p);

}

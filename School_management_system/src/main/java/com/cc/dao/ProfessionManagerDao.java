package com.cc.dao;

import com.cc.entity.Professional;

public interface ProfessionManagerDao {

	//添加专业信息
	void AddProfession(Professional p);

	//删除专业信息
	void DeleteProfession(Integer id);

	//根据Id查询专业信息
	Professional ShowProfession(Integer id);

	//修改专业信息
	void UpdateProfession(Professional p);

}

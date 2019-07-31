package com.cc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cc.dao.ProfessionManagerDao;
import com.cc.entity.Professional;
import com.cc.service.ProfessionManagerService;
import com.cc.util.NoteResult;

@Service
public class ProfessionManagerServiceImpl implements ProfessionManagerService {

	@Resource
	private ProfessionManagerDao pd;
	
	
	/**
	 * 添加专业信息
	 */
	public NoteResult AddProfession(Professional p) {
		pd.AddProfession(p);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}


	/**
	 * 删除专业信息
	 */
	public NoteResult DeleteProfession(Integer id) {
		pd.DeleteProfession(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}


	/**
	 * 根据id查询专业信息
	 */
	public NoteResult ShowProfession(Integer id) {
		Professional p=pd.ShowProfession(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setData(p);
		return result;
	}


	/**
	 * 修改专业信息
	 */
	public NoteResult UpdateProfession(Professional p) {
		pd.UpdateProfession(p);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}

}

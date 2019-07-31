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
	 * ���רҵ��Ϣ
	 */
	public NoteResult AddProfession(Professional p) {
		pd.AddProfession(p);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}


	/**
	 * ɾ��רҵ��Ϣ
	 */
	public NoteResult DeleteProfession(Integer id) {
		pd.DeleteProfession(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}


	/**
	 * ����id��ѯרҵ��Ϣ
	 */
	public NoteResult ShowProfession(Integer id) {
		Professional p=pd.ShowProfession(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setData(p);
		return result;
	}


	/**
	 * �޸�רҵ��Ϣ
	 */
	public NoteResult UpdateProfession(Professional p) {
		pd.UpdateProfession(p);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}

}

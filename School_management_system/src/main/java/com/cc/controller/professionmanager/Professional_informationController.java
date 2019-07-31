package com.cc.controller.professionmanager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.entity.Professional;
import com.cc.service.ProfessionManagerService;
import com.cc.util.NoteResult;

@Controller
public class Professional_informationController {
	
	
	@Resource
	private ProfessionManagerService ps;
	
	
	/**
	 * 添加专业
	 * @param profession_name
	 * @param profession_time
	 * @param profession_introduce
	 * @param profession_tuition
	 * @param development_direction
	 * @return
	 */
	@RequestMapping("/AddProfession.do")
	@ResponseBody
	public NoteResult AddProfession(String profession_name,String profession_time,String profession_introduce,String profession_tuition,String development_direction){
		Professional p=new Professional();
		p.setDevelopment_direction(development_direction);
		p.setProfessional_introduce(profession_introduce);
		p.setProfessional_name(profession_name);
		p.setProfessional_time(profession_time);
		p.setProfessional_tuition(new Double(profession_tuition));
		NoteResult result=ps.AddProfession(p);
		return result;
	}
	
	/**
	 * 删除专业信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/DeleteProfession.do")
	@ResponseBody
	public NoteResult DeleteProfession(Integer id){
		NoteResult result=ps.DeleteProfession(id);
		return result;
	}
	
	/**
	 * 根据id查询专业信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/ShowProfession.do")
	@ResponseBody
	public NoteResult ShowProfession(Integer id){
		NoteResult result=ps.ShowProfession(id);
		return result;
	}
	
	/**
	 * 修改专业信息
	 * @param profession_name
	 * @param profession_time
	 * @param profession_introduce
	 * @param profession_tuition
	 * @param development_direction
	 * @return
	 */
	@RequestMapping("/UpdateProfession.do")
	@ResponseBody
	public NoteResult UpdateProfession(Integer id,String profession_name,String profession_time,String profession_introduce,String profession_tuition,String development_direction){
		Professional p=new Professional();
		p.setProfessional_id(id);
		p.setDevelopment_direction(development_direction);
		p.setProfessional_introduce(profession_introduce);
		p.setProfessional_name(profession_name);
		p.setProfessional_time(profession_time);
		p.setProfessional_tuition(new Double(profession_tuition));
		NoteResult result=ps.UpdateProfession(p);
		return result;
	}
}

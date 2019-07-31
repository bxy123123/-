package com.cc.controller.placemanager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.entity.Place;
import com.cc.service.PlaceService;
import com.cc.util.NoteResult;
import com.cc.util.PageUtil;

@Controller
public class placemanagerController {


	@Resource
	private PlaceService ps;
	
	/**
	 * ��ʾ���г�����Ϣ
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/pagePlace.do")
	@ResponseBody
	public PageUtil pagePlace(String currentPage){
		PageUtil page = ps.pagePlace(currentPage);
		return page;
	}
	/**
	 * ��ӳ���
	 * @param placename
	 * @param placeplace
	 * @param placeaccommodatingPopulation
	 * @param placeindoorAndOutdoor
	 * @return
	 */
	@RequestMapping("/AddPlace.do")
	@ResponseBody
	public NoteResult AddPlace(String placename,String placeplace,int placeaccommodatingPopulation,String placeindoorAndOutdoor){
		NoteResult result=ps.AddPlace(placename,placeplace,placeaccommodatingPopulation,placeindoorAndOutdoor);
		return result;
	
	}
	
	/**
	 * ���ر༭(��ʾ������Ϣ�ڱ༭ҳ��)
	 * @param id
	 * @return
	 */
	@RequestMapping("/placeById.do")
	@ResponseBody
	public NoteResult placeById(Integer id){
		NoteResult result=ps.placeById(id);
		return result;
	}
	
	/**
	 * ���ر༭(�޸ĳ�����Ϣ)
	 * @param place_id
	 * @param placename
	 * @param placeplace
	 * @param placepeople
	 * @param placeP
	 * @return
	 */
	@RequestMapping("/UpdatePlace.do")
	@ResponseBody
	public NoteResult UpdatePlace(Integer place_id,String placename,String placeplace,int placepeople,String placeP){
		Place place=new Place();
		place.setPlace_id(place_id);
		place.setPlace_name(placename);
		place.setPlace_place(placeP);
		place.setPlace_accommodatingPopulation(placepeople);
		place.setPlace_indoorAndOutdoor(placeplace);
		NoteResult result=ps.UpdatePlace(place);
		return result;
	}
	
	/**
	 * ɾ������
	 * @param place_id
	 * @return
	 */
	@RequestMapping("/DeletePlace.do")
	@ResponseBody
	public NoteResult DeletePlace(Integer place_id){
		NoteResult result=ps.DeletePlace(place_id);
		return result;
	}
}

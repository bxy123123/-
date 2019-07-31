package com.cc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cc.dao.PlaceDao;
import com.cc.entity.Arrange;
import com.cc.entity.Place;
import com.cc.service.PlaceService;
import com.cc.util.NoteResult;
import com.cc.util.PageUtil;

@Service
public class PlaceServiceImpl implements PlaceService {

	@Resource
	private PlaceDao pd;
	
	public PageUtil pagePlace(String currentPage) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = pd.pageSize();
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<Place> list = pd.findpage(page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}

	public NoteResult AddPlace(String placename, String placeplace, int placeaccommodatingPopulation,
			String placeindoorAndOutdoor) {
		Place place = new Place();
		place.setPlace_name(placename);
		place.setPlace_place(placeplace);
		place.setPlace_accommodatingPopulation(placeaccommodatingPopulation);
		place.setPlace_indoorAndOutdoor(placeindoorAndOutdoor);
		pd.AddDao(place);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("保存成功");
		result.setData(place);
		return result;
	}
	
	public NoteResult placeById(Integer id) {
		Place p = pd.placeById(id);
		NoteResult result=new NoteResult();
		result.setData(p);
		result.setStatus(0);
		return result;
	}

	public NoteResult UpdatePlace(Place place) {
		pd.UpdatePlace(place);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}

	public NoteResult DeletePlace(Integer place_id) {
		pd.DeletePlace(place_id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}

	public NoteResult placeArrangeById(Integer id) {
		NoteResult nr = new NoteResult();
		Arrange a = pd.placeArrangeById(id);
		nr.setData(a);
		nr.setStatus(0);
		return nr;
	}

	public NoteResult AddPlacearrange(String arrangecompany, String arrangeplace, int arrangepeople,
			String arrangecontent, String arrangestoptime, String arrangeusetime) {
		Arrange arrange = new Arrange();
		arrange.setArrange_company(arrangecompany);
		arrange.setArrange_place(arrangeplace);
		arrange.setArrange_people(arrangepeople);
		arrange.setArrange_content(arrangecontent);
		arrange.setArrange_stoptime(arrangestoptime);
		arrange.setArrange_usetime(arrangeusetime);
		pd.AddPlacearrange(arrange);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("保存成功");
		result.setData(arrange);
		return result;
	}

	public NoteResult DeleteArrangePlace(Integer arrange_id) {
		pd.DeleteArrangePlace(arrange_id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	
	/**
	 * 修改场地
	 */
	public NoteResult UpdateArrangePlace(Integer arrange_id, String arrange_company, String arrange_place,
			int arrange_people, String arrange_content, String arrange_usetime, String arrange_stoptime) {
		Arrange arrange = new Arrange();
		arrange.setArrange_id(arrange_id);
		arrange.setArrange_company(arrange_company);
		arrange.setArrange_place(arrange_place);
		arrange.setArrange_people(arrange_people);
		arrange.setArrange_content(arrange_content);
		arrange.setArrange_usetime(arrange_usetime);
		arrange.setArrange_stoptime(arrange_stoptime);
		pd.UpdateArrangePlace(arrange);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	/**
	 * 修改审核状态
	 */
	public NoteResult updateArrangeStart(Integer id,Integer start,String arrangeReason) {
		System.out.println(start);
		if (start == 1) {
			pd.updateArrangeStart1(id);
			Arrange a = pd.placeArrangeById(id);
			System.out.println(a.getClubAndSchoolstatus());
			if(a.getClubAndSchoolstatus() == 1){
				pd.updateClubActivitiesStart(a.getClubAndSchoolActivities_id());
			}else if(a.getClubAndSchoolstatus() == 2){
				pd.updateSchoolActivitiesStart(a.getClubAndSchoolActivities_id());
			}
		}else if(start == 2){
			pd.updateArrangeStart2(id);
			Arrange a = pd.placeArrangeById(id);
			
			if(a.getClubAndSchoolstatus() == 1){
				pd.updateClubActivitiesStart2(a.getClubAndSchoolActivities_id());
			}else if(a.getClubAndSchoolstatus() == 2){
				pd.updateSchoolActivitiesStart2(a.getClubAndSchoolActivities_id());
			}
			
		}else if(start == 3){
			pd.updateArrangeStart3(id,arrangeReason);
		}
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	
}

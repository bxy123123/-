package com.cc.controller.placemanager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.service.PlaceService;
import com.cc.util.NoteResult;

@Controller
public class placeArrangeController {

	@Resource
	private PlaceService ps;
	
	/**
	 * 修改场地安排(显示个人信息在编辑页面)
	 * @param Manager_id
	 * @param req
	 * @return
	 */
	@RequestMapping("/placeArrangeById.do")
	@ResponseBody
	public NoteResult placeArrangeById(Integer id){
		NoteResult result=ps.placeArrangeById(id);
		return result;
	}
	
	/**
	 * 添加场地安排
	 * @param arrangecompany
	 * @param arrangeplace
	 * @param arrangepeople
	 * @param arrangecontent
	 * @return
	 */
	@RequestMapping("/AddPlacearrange.do")
	@ResponseBody
	public NoteResult AddPlacearrange(String arrangecompany,String arrangeplace,int arrangepeople,String arrangecontent,String arrangeusetime,String arrangestoptime){
		
		NoteResult result=ps.AddPlacearrange(arrangecompany,arrangeplace,arrangepeople,arrangecontent,arrangeusetime,arrangestoptime);
		return result;
	
	}
	
	/**
	 * 删除场地
	 * @param arrange_id
	 * @return
	 */
	@RequestMapping("/DeleteArrangePlace.do")
	@ResponseBody
	public NoteResult DeleteArrangePlace(Integer arrange_id){
		NoteResult result=ps.DeleteArrangePlace(arrange_id);
		return result;
	}
	
	/**
	 * 修改场地
	 * @param arrange_id
	 * @return
	 */
	@RequestMapping("/UpdateArrangePlace.do")
	@ResponseBody
	public NoteResult UpdateArrangePlace(Integer arrange_id,String arrange_company, String arrange_place, int arrange_people,
			 String arrange_content, String arrange_usetime , String arrange_stoptime){
		NoteResult result=ps.UpdateArrangePlace(arrange_id,arrange_company, arrange_place, arrange_people,
				  arrange_content, arrange_usetime , arrange_stoptime);
		return result;
	}
	
	/**
	 * 修改场地安排状态
	 * @param arrange_id
	 * @return
	 */
	@RequestMapping("/updateArrangeStart.do")
	@ResponseBody
	public NoteResult updateArrangeStart(Integer id,Integer start,String arrangeReason){
		NoteResult result=ps.updateArrangeStart(id,start,arrangeReason);
		return result;
	}
}

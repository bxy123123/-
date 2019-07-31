package com.cc.service;

import com.cc.entity.Place;
import com.cc.util.NoteResult;
import com.cc.util.PageUtil;

public interface PlaceService {

	PageUtil pagePlace(String currentPage);

	NoteResult placeById(Integer id);

	NoteResult UpdatePlace(Place place);

	NoteResult DeletePlace(Integer place_id);
	
	NoteResult AddPlace(String placename, String placeplace, int placeaccommodatingPopulation,
			String placeindoorAndOutdoor);

	NoteResult placeArrangeById(Integer id);

	NoteResult AddPlacearrange(String arrangecompany, String arrangeplace, int arrangepeople, String arrangecontent,
			String arrangeusetime, String arrangestoptime);

	NoteResult DeleteArrangePlace(Integer arrange_id);

	NoteResult UpdateArrangePlace(Integer arrange_id, String arrange_company, String arrange_place, int arrange_people,
			String arrange_content, String arrange_usetime, String arrange_stoptime);

	NoteResult updateArrangeStart(Integer id, Integer start, String arrangeReason);

}

package com.cc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cc.entity.Arrange;
import com.cc.entity.Place;

public interface PlaceDao {

	int pageSize();

	List<Place> findpage(@Param("start")int start, @Param("end")int end);

	//Ìí¼Ó³¡µØ
	void AddDao(Place place);
		
	Place placeById(Integer id);

	void UpdatePlace(Place place);

	void DeletePlace(Integer place_id);
	
	Arrange placeArrangeById(Integer id);

	void AddPlacearrange(Arrange arrange);

	void DeleteArrangePlace(Integer arrange_id);

	Arrange ArrangePlaceId(Integer arrange_id);

	void UpdateArrangePlace(Arrange arrange);

	void updateArrangeStart1(Integer id);

	void updateArrangeStart2(Integer id);

	void updateArrangeStart3(@Param("id")Integer id, @Param("arrangeReason")String arrangeReason);

	void updateClubActivitiesStart(int clubActivities_id);

	void updateClubActivitiesStart2(int clubActivities_id);

	void updateSchoolActivitiesStart(int clubAndSchoolActivities_id);

	void updateSchoolActivitiesStart2(int clubAndSchoolActivities_id);
}

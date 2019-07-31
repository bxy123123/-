package com.cc.entity;

public class Place {

	private int place_id;
	private String place_name;
	private String place_place;
	private int place_accommodatingPopulation;
	private String place_indoorAndOutdoor;
	
	
	public int getPlace_id() {
		return place_id;
	}
	public void setPlace_id(int place_id) {
		this.place_id = place_id;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getPlace_place() {
		return place_place;
	}
	public void setPlace_place(String place_place) {
		this.place_place = place_place;
	}
	public int getPlace_accommodatingPopulation() {
		return place_accommodatingPopulation;
	}
	public void setPlace_accommodatingPopulation(int place_accommodatingPopulation) {
		this.place_accommodatingPopulation = place_accommodatingPopulation;
	}
	public String getPlace_indoorAndOutdoor() {
		return place_indoorAndOutdoor;
	}
	public void setPlace_indoorAndOutdoor(String place_indoorAndOutdoor) {
		this.place_indoorAndOutdoor = place_indoorAndOutdoor;
	}
	@Override
	public String toString() {
		return "Palce [place_id=" + place_id + ", place_name=" + place_name + ", place_place=" + place_place
				+ ", place_accommodatingPopulation=" + place_accommodatingPopulation + "]";
	}
	
	
	
}

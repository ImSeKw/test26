package ksmart.project.test26.service;

import java.util.List;

public class CityAndCityFile {
	private City city;
	private List<CityFile> list;
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public List<CityFile> getList() {
		return list;
	}
	public void setList(List<CityFile> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "CityAndCityFile [city=" + city + ", list=" + list + "]";
	}
}

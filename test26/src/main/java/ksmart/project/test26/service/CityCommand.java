package ksmart.project.test26.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CityCommand {
	private String cityName;
	private List<MultipartFile> file;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		return "CityCommand [cityName=" + cityName + ", file=" + file + "]";
	}
}

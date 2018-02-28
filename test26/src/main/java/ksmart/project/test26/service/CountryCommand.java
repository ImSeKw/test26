package ksmart.project.test26.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CountryCommand {
	private int countryid;
	private String countryName;
	private List<MultipartFile> file;
	public int getCountryid() {
		return countryid;
	}
	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	
}

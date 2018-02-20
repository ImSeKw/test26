package ksmart.project.test26.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CompanyCommand {
	private String companyName;
	private List<MultipartFile> file;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	
	
	

}

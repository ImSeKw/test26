package ksmart.project.test26.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class IdolCommand {
	private int idolID;
	private String idolName;
	private List<MultipartFile> file;
	
	
	public int getIdolID() {
		return idolID;
	}
	public void setIdolID(int idolID) {
		this.idolID = idolID;
	}
	public String getIdolName() {
		return idolName;
	}
	public void setIdolName(String idolName) {
		this.idolName = idolName;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "IdolCommand [idolName=" + idolName + ", file=" + file + "]";
	}
}

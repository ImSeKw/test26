package ksmart.project.test26.service;

public class CompanyFile {
	private int companyFileId;
	private int companyId;
	private String fileName;
	private String fileExt;
	private long fileSize;
	
	public int getCompanyFileId() {
		return companyFileId;
	}
	public void setCompanyFileId(int companyFileId) {
		this.companyFileId = companyFileId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
	

}

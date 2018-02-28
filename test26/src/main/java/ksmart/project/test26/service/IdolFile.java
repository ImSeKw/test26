package ksmart.project.test26.service;

public class IdolFile {
	private int idolFileId;
	private int idolID;
	private String fileName;
	private String fileExt;
	private long fileSize;
	
	public int getIdolFileId() {
		return idolFileId;
	}
	public void setIdolFileId(int idolFileId) {
		this.idolFileId = idolFileId;
	}
	public int getIdolID() {
		return idolID;
	}
	public void setIdolID(int idolID) {
		this.idolID = idolID;
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
		return "IdolFile [idolFileId=" + idolFileId + ", idolID=" + idolID + ", fileName=" + fileName + ", fileExt="
				+ fileExt + ", fileSize=" + fileSize + "]";
	}
}

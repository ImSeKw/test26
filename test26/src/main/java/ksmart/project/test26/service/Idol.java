package ksmart.project.test26.service;

public class Idol {

	private int idolID;
	private String idolName;
	
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
	@Override
	public String toString() {
		return "IdolDao [idolID=" + idolID + ", idolName=" + idolName + "]";
	}
	
}


package ksmart.project.test26.service;

public class Country {
	private int countryId;
	private String countryName;
	

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "CountryDao [countryid=" + countryId + ", countryname=" + countryName + "]";
	}
		
}

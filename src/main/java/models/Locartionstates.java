package models;

public class Locartionstates {

	private String state;
	private String country ;
	private int latesttotalcases;
	private int diffFromPrevDay;

    public int getDiffFromPrevDay() {
        return diffFromPrevDay;
    }

    public void setDiffFromPrevDay(int diffFromPrevDay) {
        this.diffFromPrevDay = diffFromPrevDay;
    }
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	 public int getLatestTotalCases() {
	        return getLatestTotalCases();
	    }
	 public void setLatestTotalCases(int latestCases) {
			
			 this.latesttotalcases = latesttotalcases;
			
		}
	@Override
	public String toString() {
		return "Locartionstates [state=" + state + ", country=" + country + ", latesttotalcases=" + latesttotalcases
				+ "]";
	}

	

	

	

	
	
}

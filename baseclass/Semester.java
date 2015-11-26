package baseclass;
import java.io.Serializable;
import java.util.ArrayList;

public class Semester implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5379177481588314773L;
	public enum Season {
		SPRING,
		SUMMER,
		FALL,
		WINTER;
	} 
	private int year;
	private ArrayList<Class> className;
	private Season season;
	
	public Semester(ArrayList<Class> className, int year, Season season){
		this.className = className;
		this.year = year;
		this.season = season;
	}
	
	public ArrayList<Class> getClassName() {
		return className;
	}

	public void setClassName(ArrayList<Class> className) {
		this.className = className;
	}

	public Season getSeason() {
		return season;
	}
	public String getSeasonName(Season season) {
		switch (season){
			case SPRING:
				return "Spring";
			case SUMMER:
				return "Summer";
			case FALL:
				return "Fall";
			case WINTER:
				return "Winter";
			default:
				return "No season";
		}
	}
	public void setSeason(Season season) {
		this.season = season;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	public String toString() {
		return season.toString() + ": " + year;
	}

}

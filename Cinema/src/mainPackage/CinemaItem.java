package mainPackage;

import java.util.ArrayList;

public abstract class CinemaItem {
	private String title;
	private int year;
	private String country;
	private String director;
	private String musicDirector;
	private ArrayList<String> actorList;
	
	protected CinemaItem(String title, int year, String country, String director, String musicDirector) {
		this.setTitle(title);
		this.setYear(year);
		this.setCountry(country);
		this.setDirector(director);
		this.setMusicDirector(musicDirector);
		this.actorList = new ArrayList<String>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMusicDirector() {
		return musicDirector;
	}

	public void setMusicDirector(String musicDirector) {
		this.musicDirector = musicDirector;
	}

	public ArrayList<String> getActorList() {
		return actorList;
	}
}

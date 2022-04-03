package mainPackage;

public class Film extends CinemaItem {
	private int duration;
	
	public Film(String title, int year, String country, String director, String musicDirector, int duration) {
		super(title, year, country, director, musicDirector);
		this.setDuration(duration);
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return super.getTitle() + " // " + super.getYear() + " // " + super.getCountry()
				+ " // " + super.getDirector() + " // " + super.getMusicDirector() + " // " + duration;
	}
}

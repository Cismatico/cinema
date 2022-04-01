package mainPackage;

import java.util.ArrayList;

public class Controller {
	private ArrayList<Film> filmList;
	private ArrayList<Serie> serieList;

	public Controller() {
		this.filmList = new ArrayList<>();
		this.serieList = new ArrayList<>();
	}

	public ArrayList<Film> getFilmList() {
		return filmList;
	}

	public ArrayList<Serie> getSerieList() {
		return serieList;
	}
	
	public void addFilm(String title, int year, String country, String director, String musicDirector, int duration) {
		Film film = new Film(title, year, country, director, musicDirector, duration);
		filmList.add(film);
	}
	
}

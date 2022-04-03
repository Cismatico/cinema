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

	public boolean existFilm(String title) {
		for (int i = 0; i < filmList.size(); i++) {
			if (filmList.get(i).getTitle().equals(title)) {
				return true;
			}
		}
		return false;
	}

	public int searchFilmIndex(String title) {
		int index = 0;
		for (int i = 0; i < filmList.size(); i++) {
			if (filmList.get(i).getTitle().equals(title)) {
				index = i;
			}
		}
		return index;
	}

	public Film getFilm(int index) {
		return filmList.get(index);
	}

	public void changeFilmTitle(String title, String newTitle) {
		int index = searchFilmIndex(title);
		getFilm(index).setTitle(newTitle);
	}

	public void changeFilmYear(String title, int newYear) {
		int index = searchFilmIndex(title);
		getFilm(index).setYear(newYear);
	}

	public void changeFilmCountry(String title, String newCountry) {
		int index = searchFilmIndex(title);
		getFilm(index).setCountry(newCountry);
	}

	public void changeFilmDirector(String title, String newDirector) {
		int index = searchFilmIndex(title);
		getFilm(index).setDirector(newDirector);
	}

	public void changeFilmMusicDirector(String title, String newMusicDirector) {
		int index = searchFilmIndex(title);
		getFilm(index).setMusicDirector(newMusicDirector);
	}

	public void changeFilmDuration(String title, int newDuration) {
		int index = searchFilmIndex(title);
		getFilm(index).setDuration(newDuration);
	}
	
	public void removeFilm(String title) {
		int index = searchFilmIndex(title);
		filmList.remove(index);
	}
}

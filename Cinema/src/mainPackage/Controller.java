package mainPackage;

import java.util.ArrayList;

public class Controller {
	private DbController dbController;
	private ArrayList<Film> filmList;
	private ArrayList<Serie> serieList;

	public Controller(DbController dbController) {
		this.dbController = dbController;
		this.filmList = new ArrayList<>();
		this.serieList = new ArrayList<>();
	}

	public void readAllData() {
		filmList = dbController.readAllData();
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
		dbController.insert(title, year, country, director, musicDirector, duration);
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

	public void changeFilmYear(String title, int newYear) {
		int index = searchFilmIndex(title);
		getFilm(index).setYear(newYear);
		dbController.updateYear(title, newYear);
	}

	public void changeFilmCountry(String title, String newCountry) {
		int index = searchFilmIndex(title);
		getFilm(index).setCountry(newCountry);
		dbController.updateCountry(title, newCountry);
	}

	public void changeFilmDirector(String title, String newDirector) {
		int index = searchFilmIndex(title);
		getFilm(index).setDirector(newDirector);
		dbController.updateDirector(title, newDirector);
	}

	public void changeFilmMusicDirector(String title, String newMusicDirector) {
		int index = searchFilmIndex(title);
		getFilm(index).setMusicDirector(newMusicDirector);
		dbController.updateMusicDirector(title, newMusicDirector);
	}

	public void changeFilmDuration(String title, int newDuration) {
		int index = searchFilmIndex(title);
		getFilm(index).setDuration(newDuration);
		dbController.updateduration(title, newDuration);
	}

	public void removeFilm(String title) {
		int index = searchFilmIndex(title);
		filmList.remove(index);
		dbController.deleteFilm(title);
	}
}

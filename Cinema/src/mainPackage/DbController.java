package mainPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbController {
	public void insert(String title, int year, String country, String director, String musicDirector, int duration) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO films(title, year, country, director, musicDirector, duration) VALUES(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setInt(2, year);
			ps.setString(3, country);
			ps.setString(4, director);
			ps.setString(5, musicDirector);
			ps.setInt(6, duration);
			ps.execute();
			System.out.println("Data has been inserted into films table");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}

	public ArrayList<Film> readAllData() {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Film> filmList = new ArrayList<>();

		try {
			String sql = "SELECT * FROM films";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				int year = rs.getInt("year");
				String country = rs.getString("country");
				String director = rs.getString("director");
				String musicDirector = rs.getString("musicDirector");
				int duration = rs.getInt("duration");

				Film film = new Film(title, year, country, director, musicDirector, duration);
				filmList.add(film);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}

		}
		return filmList;
	}

	private static void readSpecificRow() {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "Select title from films where duration = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 167);
			rs = ps.executeQuery();

			String title = rs.getString(1);
			System.out.println(title);

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}

		}
	}

	public void updateYear(String title, int year) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE films set year = ? WHERE title = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, year);
			ps.setString(2, title);
			ps.execute();
			System.out.println("Data has been updated");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}

	public void updateCountry(String title, String country) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE films set country = ? WHERE title = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, country);
			ps.setString(2, title);
			ps.execute();
			System.out.println("Data has been updated");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}

	public void updateDirector(String title, String director) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE films set director = ? WHERE title = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, director);
			ps.setString(2, title);
			ps.execute();
			System.out.println("Data has been updated");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}

	public void updateMusicDirector(String title, String musicDirector) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE films set musicDirector = ? WHERE title = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, musicDirector);
			ps.setString(2, title);
			ps.execute();
			System.out.println("Data has been updated");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}

	public void updateduration(String title, int duration) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE films set duration = ? WHERE title = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, duration);
			ps.setString(2, title);
			ps.execute();
			System.out.println("Data has been updated");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}

	public void deleteFilm(String title) {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		try {
			String sql = "delete from films where title = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.execute();
			System.out.println("Data has been deleted");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}
}

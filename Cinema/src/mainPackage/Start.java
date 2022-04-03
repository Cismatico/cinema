package mainPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Start {

	public static void main(String[] args) {

		Controller controller = new Controller();
		View view = new View(controller);

		view.mainMenu();
	}

	private static void insert(String title, int year, String country, String director, String musicDirector,
			int duration) {
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
		}
	}

	private static void readAllData() {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

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

				System.out.println(title + " // " + year + " // " + country + " // " + director + " // " + musicDirector
						+ " // " + duration);
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

	private static void updateCountry() {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE films set country = ? WHERE title = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "España");
			ps.setString(2, "Pulp Fiction");
			ps.execute();
			System.out.println("Data has been updated");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	private static void deleteRow() {
		Connection con = DbConnection.connect();
		PreparedStatement ps = null;
		try {
			String sql = "delete from films where title = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "Pulp Fiction");
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

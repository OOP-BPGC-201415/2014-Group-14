package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SwipeIdCard {
	/*
	 * Object of this class has to be made when the "Mess Manager" clicks some
	 * shit in the GUI
	 */
	public static String validateId(String id) {
		boolean ret = !alreadyEaten(id) && checkMessOption(id) && !isOnLeave(id);
		if (alreadyEaten(id)) {
			return "Student has already eaten!";
		}
		if (!checkMessOption(id)) {
			return "Student is not registered for this mess!";
		}
		if (isOnLeave(id)) {
			return "Student is on leave!";
		}
		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement("INSERT INTO AlreadyEaten(Id) VALUES (?);");
			s.setString(1, id);
			s.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean alreadyEaten(String id) {
		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement("SELECT * FROM AlreadyEaten WHERE id=?");
			s.setString(1, id);
			s.execute();
			return s.getResultSet().first();
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}

	public static boolean checkMessOption(String id) {
		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement("SELECT * FROM StudentList WHERE Id=?");
			s.setString(1, id);
			s.execute();
			return s.getResultSet().first();
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}

	public static boolean isOnLeave(String id) {
		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement("SELECT * FROM StudentLeave WHERE Id=?");
			s.setString(1, id);
			s.execute();
			ResultSet rs = s.getResultSet();
			if (!rs.first())
				return false;
			long time = System.currentTimeMillis();
			return time > rs.getLong("Departure")
					&& time < rs.getLong("Arrival");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean newMeal() {

		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement("DELETE FROM AlreadyEaten;");
			s.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

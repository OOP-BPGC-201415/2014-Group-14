package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SwipeIdCard {
	/*
	 * Object of this class has to be made when the "Mess Manager" clicks some
	 * shit in the GUI
	 */
	public static boolean validateId(String id) {
		return !alreadyEaten(id) && checkMessOption(id) && !isOnLeave(id);
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
					.prepareStatement("SELECT * FROM StudentList WHERE id=?");
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
					.prepareStatement("SELECT * FROM StudentLeave WHERE id=?");
			s.setString(1, id);
			s.execute();
			ResultSet rs = s.getResultSet();
			if (!rs.first())
				return false;
			long time = System.currentTimeMillis();
			return time < rs.getDate("Departure").getTime()
					|| time > rs.getDate("Arrival").getTime();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

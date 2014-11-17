package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import backend.DatabaseManager;

public class SessionHelper {
	public static Session getSession(String hash) {
		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement("SELECT * FROM Sessions WHERE hash=?;");
			s.setString(1, hash);
			s.execute();
			ResultSet rs = s.getResultSet();
			if (!rs.first())
				return null;
			return new Session(rs.getInt("designation"), rs.getInt("id"));
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void deleteSession(String hash) {
		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement("DELETE FROM Sessions WHERE hash=?;");
			s.setString(1, hash);
			s.execute();
		} catch (Exception e) {
		}
	}
}

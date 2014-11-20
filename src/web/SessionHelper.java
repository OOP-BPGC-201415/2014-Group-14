package web;

import java.math.BigInteger;
import java.security.SecureRandom;
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
			return new Session(rs.getInt("id"), rs.getInt("designation"), rs
					.getLong("timestamp"), hash);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Session newSession(int id, int designation) {
		try {
			deleteSession(id, designation);
			String hash = new BigInteger(130, new SecureRandom())
					.toString(32);
			Connection dbConn = DatabaseManager.getConnection();
			PreparedStatement s = dbConn
					.prepareStatement("INSERT INTO Sessions (hash, designation, id, timestamp) values(?, ?, ?, ?)");

			s.setString(1, hash);
			s.setInt(2, designation);
			s.setInt(3, id);
			long time = System.currentTimeMillis();
			s.setLong(4, time);
			s.execute();
			return new Session(designation, id, time, hash);
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}
	
	public static void deleteSession(int id, int designation) {
		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement("DELETE FROM Sessions WHERE id=? AND designation=?;");
			s.setInt(1, id);
			s.setInt(2, designation);
			s.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

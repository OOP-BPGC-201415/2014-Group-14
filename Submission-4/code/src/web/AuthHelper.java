package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import backend.DatabaseManager;
import actors.Person;

public class AuthHelper {
	public static Person validate(String user, String pass) {
		try {
			Connection dbConn = DatabaseManager.getConnection();
			String hash = HashGenerator.getHash(user.toLowerCase(), pass);
			PreparedStatement s = dbConn
					.prepareStatement("SELECT * FROM Login WHERE hash=?;");
			s.setString(1, hash);
			s.execute();
			final ResultSet rs = s.getResultSet();
			if (!rs.first())
				return null;
			final int id = rs.getInt("id");
			final int desig = rs.getInt("designation");
			return new Person() {
				public int getId() {
					return id;
				}

				public int getDesignation() {
					return desig;
				}
			};
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

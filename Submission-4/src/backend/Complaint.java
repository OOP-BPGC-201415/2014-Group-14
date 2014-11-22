package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Complaint {
	private String from;
	private String text;

	public Complaint(String from, String text) {
		this.from = from;
		this.text = text;
	}

	public String getFrom() {
		return from;
	}

	public String getText() {
		return text;
	}

	public static boolean addComplaint(String from, String text) {
		/*
		 * Add methods to interact with and take the complaint as input Will add
		 * the complaint to the - "complaint" table. Assume the super-global
		 * object of the current session is available
		 */

		// To catch any Funny exceptions...!!
		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement p = c
					.prepareStatement("INSERT INTO Complaint (`From`, Text, Status) VALUES(?, ?, ?)");
			p.setString(1, from);
			p.setString(2, text);
			p.setInt(3, 0);
			p.execute();
			p.close();
			c.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static ArrayList<Complaint> getComplaints() {
		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement p = c.prepareStatement("SELECT * FROM Complaint");
			p.execute();
			ResultSet rs = p.getResultSet();
			rs.beforeFirst();
			ArrayList<Complaint> ret = new ArrayList<>();
			while (rs.next()) {
				ret.add(new Complaint(rs.getString("From"), rs
						.getString("Text")));
			}
			return ret;
		} catch (Exception e) {
			return null;
		}
	}
}

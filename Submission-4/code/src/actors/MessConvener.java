package actors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import web.HashGenerator;
import backend.Complaint;
import backend.DatabaseManager;
import backend.Hygiene;
import backend.Menu;

public class MessConvener extends Person {

	public int getDesignation() {
		return 1;
	};

	public int getId() {
		return 2;
	};

	public void submitHygieneReport(String report) {
		/*
		 * Actual function when implemented will take some object obj as
		 * parameter obj will be the Object of the String Insert the data into
		 * table - "Hygiene Report"
		 */
		Hygiene.addMonthlyReport(report);
	}

	public static ArrayList<Complaint> viewComplaints() {
		/*
		 * Get the values from the the "Complaints" table and display Actual
		 * return type is a hash array
		 */
		return Complaint.getComplaints();
	}

	public void setMenu(Menu.Day day, Menu.Meal meal, String menuData) {
		Menu.getMenu().setMenuFor(day, meal, menuData);

	}

	public static void setConvener(String name, String pass, String phone) {
		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement("DELETE FROM Login WHERE Designation=? AND SR=?;");
			int dbId = 2;
			s.setInt(1, 1);
			s.setInt(2, dbId);
			s.execute();
			s = c.prepareStatement("UPDATE NonStudentList SET Name=?, Phone=? WHERE SR=?;");
			s.setString(1, name);
			s.setString(2, phone);
			s.setInt(3, dbId);
			s.execute();
			s = c.prepareStatement("INSERT INTO Login (Hash, Id, Designation) VALUES(?, ?, ?);");
			s.setString(1, HashGenerator.getHash("convener", pass));
			s.setInt(2, dbId);
			s.setInt(3, 1);
			s.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		setConvener("Clark Kent", "yaypassword", "912234234234");
	}

}

package actors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import web.HashGenerator;
import backend.DatabaseManager;
import backend.Menu;

public class MessManager {
	public String name;
	public String phoneNumber;

	public MessManager() {
		/*
		 * Assuming that there is only one Mess Manager Implement Code To get
		 * the data from the database and fill the field up. Table where the
		 * data can be found - "Non Students List" Identify the "post" field as
		 * "Mess Manager"
		 */
		try {

			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement("SELECT * FROM NonStudentList WHERE SR=?;");
			s.setInt(1, 1);
			s.execute();
			ResultSet rs = s.getResultSet();
			rs.first();
			name = rs.getString("Name");
			phoneNumber = rs.getString("Phone");
			rs.close();
			s.close();
			c.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void approveLeaveRequest() {
		/*
		 * Add Code To Implement This
		 */
	}

	public void getHygieneReports() {
		/*
		 * Add Code To Implement This
		 */

	}

	public void addWorker() {
		/*
		 * Add Code To Implement This
		 */
	}

	public void removeWorker() {
		/*
		 * Add Code To Implement This
		 */

	}

	public void setMenu(Menu.Day day, Menu.Meal meal, String menuData) {
		/*
		 * Add Code To Implement This This will use the Menu class
		 */
		Menu.getMenu().setMenuFor(day, meal, menuData);
	}

	public void setFoodRate() {
		/*
		 * Add Code To Implement This
		 */
	}

	public void respondToHygieneReport() {
		/*
		 * Add Code To Implement This
		 */
	}

	public static void setManager(String name, String pass, String phone) {
		try {
			Connection c = DatabaseManager.getConnection();
			PreparedStatement s = c
					.prepareStatement("DELETE FROM Login WHERE Designation=? AND Id=?;");
			s.setInt(1, 1);
			s.setInt(2, 1);
			s.execute();
			s = c.prepareStatement("UPDATE NonStudentList SET Name=?, Phone=?;");
			s.setString(1, name);
			s.setString(2, phone);
			s.execute();
			int dbId = 1;
			s = c.prepareStatement("INSERT INTO Login (Hash, Id, Designation) VALUES(?, ?, ?);");
			s.setString(1, HashGenerator.getHash("manager", pass));
			s.setInt(2, dbId);
			s.setInt(3, 1);
			s.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		setManager("Johnny Appleseed", "yaypassword", "234234234234");
	}

}

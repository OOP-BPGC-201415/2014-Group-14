package backend;

import actors.*;
import java.sql.*;
import java.util.Calendar;

public class Hygiene {
	public static void addMonthlyReport(String report) {
		/*
		 * Interact with the table "Hygiene Report"
		 */
		try {
			Connection conn = DatabaseManager.getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO HygieneReport (Month, Year, Report)"
							+ "VALUES (?, ?, ?)");

			// Bind The Values Into The parameters
			stmt.setInt(1, Calendar.getInstance().get(Calendar.MONTH));
			stmt.setInt(2, Calendar.getInstance().get(Calendar.YEAR));
			stmt.setString(3, report);
			stmt.execute();

			// Cleaning Up
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getReportFor() {
		/*
		 * This will call the Complaint Class GUI invocation is req. here which
		 * in turns calls the Complaint Class
		 */
	}
}

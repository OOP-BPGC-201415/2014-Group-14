package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class Menu {

	public enum Day {
		Monday(0), Tuesday(1), Wednesday(2), Thursday(3), Friday(4), Saturday(5), Sunday(
				6);
		private int id;

		Day(int id) {
			this.id = id;
		}

		public int getValue() {
			return id;
		}
	}

	public enum Meal {
		Breakfast("Breakfast"), Lunch("Lunch"), Snacks("Snacks"), Dinner(
				"Dinner");
		private String id;

		Meal(String id) {
			this.id = id;
		}

		public String getValue() {
			return id;
		}
	}

	private HashMap<Integer, HashMap<Meal, String>> menuMap;

	private Menu(HashMap<Integer, HashMap<Meal, String>> menuMap) {
		this.menuMap = menuMap;
	}

	public String getMenuFor(Day day, Meal meal) {
		return menuMap.get(day.getValue()).get(meal);
	}

	public static Menu getMenu() {

		/*
		 * Get the values from the table -"Menu" Actual Return type is a String
		 * array
		 */

		// To catch any Funny exceptions...!!
		try {
			Connection conn = DatabaseManager.getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM Menu");

			// Executing the query and collecting it in a ResultSet.
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			HashMap<Integer, HashMap<Meal, String>> map = new HashMap<>();
			while (rs.next()) {
				HashMap<Meal, String> mealmap = new HashMap<>();
				mealmap.put(Meal.Breakfast, rs.getString("Breakfast"));
				mealmap.put(Meal.Lunch, rs.getString("Lunch"));
				mealmap.put(Meal.Snacks, rs.getString("Snacks"));
				mealmap.put(Meal.Dinner, rs.getString("Dinner"));
				map.put(rs.getInt("Day"), mealmap);
			}
			// Cleaning Up
			rs.close();
			stmt.close();
			conn.close();
			return new Menu(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setMenuFor(Day day, Meal meal, String menuData) {
		/*
		 * Take input here from the GUI itself Put the data in to the database
		 * as a String Call this function from GUI
		 */

		// To catch any Funny exceptions...!!
		try {
			Connection conn = DatabaseManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE MENU SET "
					+ meal.getValue() + "=? WHERE Day=?");
			// Bind The Values Into The parameters
			stmt.setString(1, menuData);
			stmt.setInt(2, day.getValue());
			stmt.execute();
			stmt.close();
			conn.close();
			if (!menuMap.containsKey(day))
				menuMap.put(day.getValue(), new HashMap<Meal, String>());
			menuMap.get(day.getValue()).put(meal, menuData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Menu m = getMenu();
		for (Day d : Day.values()) {
			m.setMenuFor(d, Meal.Breakfast, "Aloo paratha");
			m.setMenuFor(d, Meal.Lunch, "Orange gravy");
			m.setMenuFor(d, Meal.Snacks, "Samosa");
			m.setMenuFor(d, Meal.Dinner, "Orange gravy");
		}
	}

}

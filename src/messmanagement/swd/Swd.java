package swd;

import backend.*;
import actors.*;
import java.sql.*;

public class Swd
{

	private static void updateList (String idNumber,int messOption)
	{
		/*
		* takeMonthlyLeave Function calls this function to put the data in to the table
		* table name - "student list"
		*/

		/*
		* To Invoke the static method's of the StudentList class.. Do it  like this
		* StudentList.viewStudentList () 
		*/	

		try
		{
			Connection conn = DatabaseManager.dbConn; // Holds The Connection
			PreparedStatement stmt; // Holds The Prepared Statement
			String sql; // Holds The SQL Queary We are Going tTo Execute

			sql = "INSERT INTO StudentList (Next_Mess_Option) " + "VALUES (?) WHERE Id_Number = ? ";			
			stmt = conn.prepareStatement (sql);

			stmt.setInt (1,messOption);
			stmt.setString (2,idNumber);

			ResultSet rs = stmt.executeQuery(sql);

			rs.close();
		    stmt.close();
		    conn.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{

		}

	}
	public static void takeLeaveRequests (String idNumber)
	{
		/*
		* Takes in leave requests from the student
		* Updates the "leave" table
		*/
	}

	public static class StudentList
	{
		public static ResultSet viewStudentList ()
		{

			ResultSet rs = null;
			try
			{
				Connection conn = DatabaseManager.dbConn; // Holds The Connection
				PreparedStatement stmt; // Holds The Prepared Statement
				String sql; // Holds The SQL Queary We are Going tTo Execute

				sql = "SELECT * FROM StudentList";			
				stmt = conn.prepareStatement (sql);

				rs = stmt.executeQuery(sql);

				
			    stmt.close();
			    conn.close();

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally 
			{
				return rs;
			}
		}
		public static void addStudent (Student s)
		{
			/*
			* Method to add the entry into the database 
			*/

			try
			{
				Connection conn = DatabaseManager.dbConn; // Holds The Connection
				PreparedStatement stmt; // Holds The Prepared Statement
				String sql; // Holds The SQL Queary We are Going tTo Execute

				sql = "INSERT INTO StudentList (Name,Id_No,Hostel,Current_Mess_Option) " + "VALUES (?,?,?,?)";			
				stmt = conn.prepareStatement (sql);

				stmt.setString (1,s.studentName);
				stmt.setString (2,s.studentId);
				stmt.setString (3,s.studentHostel);
				stmt.setInt (4,s.messOption);
				
				ResultSet rs = stmt.executeQuery(sql);

				rs.close();
			    stmt.close();
			    conn.close();

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally 
			{

			}


		}	
	}			
}


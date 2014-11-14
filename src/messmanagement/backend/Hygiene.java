package backend;

import actors.*;
import java.sql.*;
import java.util.Calendar;


public class Hygiene 
{
	public void addMonthlyCheck (String report)
	{
		/*
		* Interact with the table "Hygiene Report"
		*/
		
		try 
		{
		    
		    Connection conn = DatabaseManager.dbConn;
		    PreparedStatement stmt;
		    String sql;
		    
		    sql = "INSERT INTO HygieneReport (Month,Report,Designation)"
		    +"VALUES (?,?,?)";		    ;
		    stmt = conn.prepareStatement(sql);

		   	
		    
		    Calendar cal = Calendar.getInstance(); // This is to add the month field 
		    int month = cal.get(cal.MONTH) +1; // Month in Integer Format

		    // Bind The Values Into The parameters
		    stmt.setString (1,cal.toString());
		    stmt.setString (2,report);
		    stmt.setString (3,SessionWrapper.activeSession.userDesignation);
		  

		    // Executing the query and collecting it in a ResultSet.
		    ResultSet rs = stmt.executeQuery(sql);
		   
		    // Cleaning Up
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

	public void registerComplaint ()
	{
		/*
		* This will call the Complaint Class
		* GUI invocation is req. here which in turns calls the Complaint Class
		*/
	}
}

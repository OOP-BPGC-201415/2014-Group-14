package backend;

import actors.*;
import java.sql.*;

public class Menu
{
	public static String getMenu (String day,String time)
	{	
		String returnValue="";

		/*	
		* Get the values from the table -"Menu"
		* Actual Return type is a String array
		*/

		// To catch any Funny exceptions...!!
		try 
		{
		    Connection conn = DatabaseManager.dbConn;
		    PreparedStatement stmt;
		    String sql;
		    
		    sql = "SELECT * FROM Menu WHERE Day = ?";
		    stmt = conn.prepareStatement(sql);
		   	
		    // Bind The Values Into The parameters
		    stmt.setString (1,day);
		    
		   

		    // Executing the query and collecting it in a ResultSet.
		    ResultSet rs = stmt.executeQuery(sql);
		    rs.first ();

		    if (time.equals ("Breakfast"))
		    {
		    	returnValue = rs.getString ("Breakfast");
		    }
		    else if (time.equals ("Lunch"))
		    {
		    	returnValue = rs.getString ("Lunch");
		    }
		    else if (time.equals ("Dinner"))
		    {
		    	returnValue = rs.getString ("Dinner");
		    }
		    else if (time.equals("Snacks"))
		    {
		    	returnValue = rs.getString ("Snacks");

		    }
		    else
		    {
		    	returnValue = "Some Internal Error...!!";
		    }
		
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
		    return returnValue;

		}

	}
	
	public static void setMenu (String day,String time,String menuData)
	{
		/* 
		* Take input here from the GUI itself
		* Put the data in to the database as a String
		* Call this function from GUI
		*/
		
		// To catch any Funny exceptions...!!
		try 
		{
		    Connection conn = DatabaseManager.dbConn;
		    PreparedStatement stmt;
		    String sql;
		    
		    sql = "INSERT INTO Menu ("+time+") VALUES (?) WHERE Day="+day;
		    stmt = conn.prepareStatement(sql);
		   	
		    // Bind The Values Into The parameters
		    stmt.setString (1,menuData);
		    
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

	 
}

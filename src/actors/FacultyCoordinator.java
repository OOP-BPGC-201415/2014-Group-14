package actors;

import backend.*;
import java.sql.*;

public class FacultyCoordinator
{
	public String name;
	public String phoneNumber;
	
	public FacultyCoordinator ()
	{
	
		/* 
		* Add methods to retrive all other information from the database.
		* Table where data can be found Table where the data can be found - "Non Students List"
		* Identify the "post" field as "Faculty Coordinator"
		*/

		try 
		{
		 	
		    Connection conn = DatabaseManager.dbConn;
		    PreparedStatement stmt;
		    String sql;
		    
		    sql = "SELECT Name,Phone_Number FROM NonStudentList WHERE Id_No = ?";
		    stmt = conn.prepareStatement(sql);

		   	
		    // Bind The Values Into The parameters
		    stmt.setString (1,SessionWrapper.activeSession.userId);
		  

		    // Executing the query and collecting it in a ResultSet.
		   ResultSet rs = stmt.executeQuery(sql);
		   rs.first ();
		   this.name = rs.getString ("Name");
		   this.phoneNumber = rs.getString ("Phone_Number");
			
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
	
	public void imposeFine ()
	{
		/*
		* Add Code To Implement This
		*/
	}
		
	public void decideFoodRate ()
	{	
		/*
		* Add Code To Implement This
		*/
	}

}


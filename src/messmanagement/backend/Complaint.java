package backend;

import actors.*;
import java.sql.*;

public class Complaint 
{
	public void addComplaint (String complaintSubject,String complaintBody)
	{
		/*
		* Add methods to ineteract with use and take the complaint as input
		* Will add the complaint to the - "complaint" table
		* Assume the super-global object of the current session is available
		*/

		// To catch any Funny exceptions...!!
		try 
		{

		    Connection conn = DatabaseManager.dbConn;
		    PreparedStatement stmt;
		    String sql;
		    
		    sql = "INSERT INTO Complaint (User_Desigmation,User_Id,Complaint_Subject,Complaint_Body,Complaint_Status)" + 
		    "VALUES (?,?,?,?,?)";
		    stmt = conn.prepareStatement(sql);
		   	
		    // Bind The Values Into The parameters

		    stmt.setString (1,SessionWrapper.activeSession.userDesignation);
		    stmt.setString (2,SessionWrapper.activeSession.userId);
		    stmt.setString (3,complaintSubject);
		    stmt.setString (4,complaintBody);
		    stmt.setInt (5,0);

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


	public ResultSet viewComplaints ()
	{
		/*
		* Will view the complaint to the - "complaint" table
		* Display it according to the gui
		* Return type will will be hash type Or even better ResultSet
		* only retrive complaints that are not viewed
		*/

		ResultSet rs = null; // The return Variable

		// To catch any Funny exceptions...!!
		try 
		{

		    Connection conn = DatabaseManager.dbConn;
		    PreparedStatement stmt;
		    String sql;
		    
		    sql = "SELECT * FROM Complaint";
		    stmt = conn.prepareStatement(sql);
		   	
		    // Executing the query and collecting it in a ResultSet.
		    rs = stmt.executeQuery(sql);

		    // Cleaning Up
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
	public void notifyOthers ()
	{
		/*
		* Notify the mess-manager
		* You have to add Worker Leave Database or the worker database will have a column approved or not.
		*/
	}
	public void imposeFine ()
	{
		/*
		* Just Impose It...!!
		*/
	}
}

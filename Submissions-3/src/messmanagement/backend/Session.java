package backend;

import actors.*;
import java.sql.*;

/*
* One of the most important class
* A super object of this class has to be created to be used in all the other classes
* The application should always be aware of the session that it currently is
* It acts as a "State Variable
*/

public class Session
{
	public String userId;
	public String userDesignation;
	
	public Session (String userId,String userPassword,String userDesignation)
	{
		// Every Time the software will be used a session will be created
		// For every session one database connection will be created		

		DatabaseManager.dbConn = DatabaseManager.getConnection ();
		
		if (validateSession (userId,userPassword,userDesignation) == true )
		{
			this.userId = userId;
			this.userDesignation = userDesignation;
		}
		else
		{
			System.out.println ("Invalid Login Credentials");
		}
	}
	public boolean validateSession (String userId,String userPassword,String userDesignation)
	{
		boolean returnValue = false;
		if (userDesignation.equals("Student"))
		{
			/*
			* Check the login table to validate the credentials
			*/
		}
		else
		{
			/*
			* Check the login table to validate
			*/
	
		}
	return returnValue;
	}

}
		

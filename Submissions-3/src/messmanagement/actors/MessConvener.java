package actors;

import backend.*;
import java.sql.*;

public class MessConvener extends Student
{
	public MessConvener ()
	{
		super (SessionWrapper.activeSession.userId);
		/*
		* Assuming that there is only one Mess Manager
		* Implement Code To get the data from the database and fill the field up.
		* Table where the data can be found - "Non Students List"
		* Identify the "post" field as "Mess Manager"
		*/
	}

	public void submitHygieneReport (String report)
	{
		/*
		* Actual function when implemented will take some object obj as parameter
		* obj will be the Object of the String
		* Insert the data into table - "Hygiene Report"
		*/
		Hygiene h = new Hygiene ();
		h.addMonthlyCheck (report);
	
	}
	
	public ResultSet viewComplaints ()
	{
		/* 
		* Get the values from the the "Complaints" table and display
		* Actual return type is a hash array
		*/
		Complaint c = new Complaint ();
		return c.viewComplaints ();
	}
	
	public void setMenu (String day,String time,String menuData)
	{	
		/* 
		* Take some string values from the user
		* Convert the list into a JSON array and store it in the database
		* Table to insert into "Menu"
		*/
		Menu.setMenu (day,time,menuData);

	}
	
}


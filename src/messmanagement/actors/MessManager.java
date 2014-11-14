package actors;

import backend.*;
import java.sql.*;

public class MessManager
{
	public String name;
	public String phoneNumber;
	
	public MessManager ()
	{
		/*
		* Assuming that there is only one Mess Manager
		* Implement Code To get the data from the database and fill the field up.
		* Table where the data can be found - "Non Students List"
		* Identify the "post" field as "Mess Manager"
		*/
	}
	
	public void approveLeaveRequest ()
	{
		/*
		* Add Code To Implement This
		*/
	}
	public void getHygieneReports ()
	{
		/*
		* Add Code To Implement This
		*/
	
	}
	public void addWorker ()
	{
		/*
		* Add Code To Implement This
		*/
	}
	public void removeWorker ()
	{
		/*
		* Add Code To Implement This
		*/
	
	}
	public void setMenu (String day,String time,String menuData)
	{
		/*
		* Add Code To Implement This
		* This will use the Menu class
		*/
		Menu.setMenu (day,time,menuData);
	}
	public void setFoodRate ()
	{
		/*
		* Add Code To Implement This
		*/
	}
	public void respondToHygieneReport ()
	{
		/*
		* Add Code To Implement This
		*/	
	}
	
}


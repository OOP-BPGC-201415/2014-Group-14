package backend;

import actors.*;
import java.sql.*;


public class SwipeIdCard 
{
	/*
	* Object of this class has to be made when the "Mess Manager" clicks some shit in the GUI
	*/
	public String onSwipeIdCard (String idNumber)
	{
		String returnMessage;
		if (checkIfEaten(idNumber) == true)
		{
			returnMessage = "Student Has Already Consumed Meal...!! ";
		}
		else if (checkIfOnLeave(idNumber) == true)
		{
			returnMessage = "You are on leave...Come Eat Tomorrow...!! ";
		}
		else if (checkMessOption (idNumber) == false )
		{
			returnMessage = "You are not from this mess...!! ";
		}
		else
		{
			returnMessage = "Best Of Luck For Eating in this mess...!!";
		}

		return returnMessage;
	}

	private boolean checkIfEaten(String idNumber)
	{
		boolean result=true;
		/*
		* check table - "Not Decided Yet...!"
		*/
		return result;
	}

	private boolean checkMessOption (String idNumber)
	{
		boolean result=true;
		/*
		* Check the table - "Students List"
		*/
		return result;
	}

	private boolean checkIfOnLeave (String idNumber)
	{
		boolean result=true;
		/*
		* Check the table - "Leave"
		*/
		return result;
	}

}

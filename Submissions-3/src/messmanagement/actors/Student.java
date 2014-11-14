package actors;

import backend.*;
import java.sql.*;
public class Student
{
	public String studentName;
	public String studentId;
	public String studentHostel;
	public int messOption;
	
	public Student (String idNumber)
	{
		this.studentId = idNumber ;
		this.studentName = "";
		this.studentHostel = "";
		this.messOption = 0;
		
	}
	public void voteForMess ()
	{
		/*
		* Add Code To Implement This
		*/
	}
	public void applyForLeave ()
	{
		/*
		* Add Code To Implement This
		*/
	}
	public void fillComplaint (String complaintSubject,String complaintBody)
	{
		/*
		* Add Code To Implement This
		*/
		Complaint c = new Complaint ();
		c.addComplaint (complaintSubject,complaintBody);

	}
}

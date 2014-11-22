package actors;


public class Worker
{
	public String workerName;
	public String workerId;

	public void recordLeave ()
	{
		/* 
		* Add the leave request to the database "Worker"
		*/
	} 
	public void notifyOthers ()
	{
		/*
		* Notify the mess-manager
		* You have to add Worker Leave Database or the worker database will have a column approved or not.
		*/
	}
}

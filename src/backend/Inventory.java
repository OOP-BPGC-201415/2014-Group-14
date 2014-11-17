package backend;

import actors.*;
import java.sql.*;

public class Inventory 
{

	public ResultSet getAllItems ()
	{
		/* 
		* Get the values from the the "Inventory" table.
		* Actual return type is a hash array
		*/
	
		ResultSet rs =  null;

		// To catch any Funny exceptions...!!
		try 
		{
		   
		    Connection conn = DatabaseManager.dbConn;
		    PreparedStatement stmt;
		    String sql;
		    
		    sql = "SELECT * FROM  Inventory";
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

	public void addItem (String itemName,int itemPrice,int itemQuantity)
	{
		/*
		* Add methods to enter the item into database.
		* Database table to look - "Inventory"
		*/
		
		// To catch any Funny exceptions...!!
		try 
		{
		    Connection conn = DatabaseManager.dbConn;
		    PreparedStatement stmt;
		    String sql;
		    
		    sql = "INSERT INTO Inventory (Item_Name,Item_Price,Item_Quantity)" + 
		    "VALUES (?,?,?)";
		    stmt = conn.prepareStatement(sql);
		   	
		    // Bind The Values Into The parameters

		    stmt.setString (1,itemName);
		    stmt.setInt (2,itemPrice);
		    stmt.setInt (3,itemQuantity);
		   

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
	public int getPriceOfItem (String itemName)
	{
		int price=0;
		/*
		* Query the database table "Inventory" and return the price
		* Note Store the price in the above declared price variable
		*/
		ResultSet rs =  null;

		// To catch any Funny exceptions...!!
		try 
		{
		    Connection conn = DatabaseManager.dbConn;
		    PreparedStatement stmt;
		    String sql;
		    
		    sql = "SELECT Item_Price FROM  Inventory WHERE Item_Name = ?";
		    stmt = conn.prepareStatement(sql);
		    stmt.setString (1,itemName);
		   	
		    // Executing the query and collecting it in a ResultSet.
		    rs = stmt.executeQuery(sql);

		    rs.first ();
		    price = rs.getInt ("Item_Price");
		
		    // Cleaning Up
		  	rs.close ();
		    stmt.close();
		    conn.close();

		}
		catch (Exception e) 
		{
		     e.printStackTrace();
		}
		finally
		{
		    return price;

		}


	}
	
}

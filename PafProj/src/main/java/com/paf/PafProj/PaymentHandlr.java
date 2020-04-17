package com.paf.PafProj;

import java.sql.*;
import java.util.ArrayList;

public class PaymentHandlr {

	//Select All
	public ArrayList<Payment> SelectAll() throws Exception
	{
		ArrayList<Payment> list = new ArrayList();
		String Query = "SELECT * FROM `paymendetails`";
		DBConnection newconn = new DBConnection();
		ResultSet Select = newconn.GtResultSet(Query);
		
			
			while(Select.next())
			{
				Payment pay = new Payment();
				
				pay.setP_ID(Select.getString(1));
				pay.setPaient_id(Select.getInt(2));
				pay.setP_amount(Select.getDouble(3));
				pay.setP_method(Select.getString(4));
				pay.setP_Description(Select.getString(5));

				
				list.add(pay);
			}
			newconn.con.close();
			return list;
			
	}
	
	

	//Select Where
	public Payment SelectWhere(int pid) throws SQLException
	{
		String Query = "SELECT * FROM `paymendetails` WHERE `P_ID` = "+pid+" ";
		DBConnection newconn = new DBConnection();
		ResultSet Select = newconn.GtResultSet(Query); 
		
		Payment pay = new Payment();
		
		pay.setP_ID(Select.getString(1));
		pay.setPaient_id(Select.getInt(2));
		pay.setP_amount(Select.getDouble(3));
		pay.setP_method(Select.getString(4));
		pay.setP_Description(Select.getString(5));


		newconn.con.close();
		
		return pay;
	}

	//Insert Into
	public String InsertIntoPayment(Payment pay) throws SQLException
	{
		DBConnection newconn = new DBConnection();
		String Query = "INSERT INTO `paymendetails` (``, ``) VALUES (?,?)";
		PreparedStatement Insert = newconn.GtPrepStatement(Query);
		
		Insert.setString(1, pay.getP_ID());
		Insert.setInt(2, pay.getPaient_id());
		Insert.setDouble(2, pay.getP_amount());
		Insert.setString(1, pay.getP_method());
		Insert.setString(1, pay.getP_Description());
		
		
		if(!Insert.execute())
		{
			newconn.con.close();
			return "Data Inserted Sucessfully";
		}
		else
		{
			newconn.con.close();
			return "Error Data Insert Unsucessful";
		}
		
		
	}
	
	//Delete
	public String DeleteDetails(String payid) throws SQLException
	{
		DBConnection newconn = new DBConnection();
		String query = "DELETE FROM `paymendetails` WHERE PaymenID = ? ";
		PreparedStatement perpstat = newconn.GtPrepStatement(query);
		
		perpstat.setString(1,payid);
		
		if(!perpstat.execute())
		{
			newconn.con.close();
			return  "Delete SucessFull";
		}
		else
		{
			newconn.con.close();
			return  "Delete UnsucessFull";
		}
	}
	
	//Update
	public String updatePayment(Payment pay)throws SQLException
	{
		DBConnection newconn = new DBConnection();
		String query = "UPDATE `paymendetails` SET `P_amount` = ? WHERE `paymendetails`.`P_ID` = 'p0001'; ";
	    PreparedStatement prepstat = newconn.GtPrepStatement(query);
	   
	    prepstat.setInt(1, pay.getPaient_id());
	    prepstat.setDouble(2, pay.getP_amount());
	    prepstat.setString(3, pay.getP_method());
	    prepstat.setString(4, pay.getP_Description());
	    
	    prepstat.setString(5, pay.getP_ID());
	    
	    if(!prepstat.execute())
	    {
	    	newconn.con.close();
			return "Successfully Updated";
	    }
	    else
	    {
	    	newconn.con.close();
			return "Updation Unsuccessful";
	    }
	}
	
}

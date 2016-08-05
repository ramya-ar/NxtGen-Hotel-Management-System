package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.CreateCustModel;
import model.UpdateCustModel;

public class UpdateCustDao {
	
	private Connection connect;
	private ResultSet resultset;
	private Statement statement;
	
	private String url="jdbc:mysql://www.papademas.net:3306/mydb";
	private String username="dbuser";
	private String password="db1";
	
	public UpdateCustModel update(UpdateCustModel customerModel)
	
	{
		try
		{
			connect = DriverManager.getConnection(url,username, password);
		}
		
		catch(SQLException e)
		{
			System.out.println("Error");
			System.exit(-1);
		}
	
		String d= customerModel.getCustid();
		int s= Integer.parseInt(d);
		String sql="update rprojectcustomer set custid=?, cfname=?, clname=?, cphn=?, caddr=? where custid=?";
		try (PreparedStatement statement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
		{
			statement.setString(1, customerModel.getCustid());
			statement.setString(2, customerModel.getCfname());
			statement.setString(3, customerModel.getClname());
			statement.setString(4, customerModel.getCphn());
			statement.setString(5, customerModel.getCaddr());
			statement.setString(6, customerModel.getCustid());
			statement.executeUpdate();
			
			System.out.println(statement.getUpdateCount());
			ResultSet resultset = statement.getGeneratedKeys();
		}
		
		catch(SQLException e)
		{
			customerModel=null;
			System.out.println("Error");		
			
		}
		return customerModel;
		
	}

}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.UpdateEmpModel;


public class UpdateEmpDao {
	
	private Connection connect;
	private ResultSet resultset;
	private Statement statement;
	
	private String url="jdbc:mysql://www.papademas.net:3306/mydb";
	private String username="dbuser";
	private String password="db1";
	
	public UpdateEmpModel update(UpdateEmpModel empModel)
	
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
	
		String d= empModel.getEid();
		int s= Integer.parseInt(d);
		String sql="update rprojectemployee set eid=?, efname=?, elname=?, ephn=?, eaddr=? where eid=?";
		try (PreparedStatement statement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
		{
			statement.setString(1, empModel.getEid());
			statement.setString(2, empModel.getEfname());
			statement.setString(3, empModel.getElname());
			statement.setString(4, empModel.getEphn());
			statement.setString(5, empModel.getEaddr());
			statement.setString(6, empModel.getEid());
			statement.executeUpdate();
			
			System.out.println(statement.getUpdateCount());
			ResultSet resultset = statement.getGeneratedKeys();
		}
		
		catch(SQLException e)
		{
			empModel=null;
			System.out.println("Error");		
			
		}
		return empModel;
		
	}

}

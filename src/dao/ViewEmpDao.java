package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ViewEmpModel;
import java.util.ArrayList;

public class ViewEmpDao {
	private Connection connection;
	 //Database connection parameters
	    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
	    private String username = "dbuser";
	    private String password = "db1";

	    public ArrayList<String> setEid(){
		ArrayList<String> names1 = new ArrayList<String>();
		ResultSet resultset;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Error creating connection to database");
			System.exit(-1);
		}
		String sql = "select eid from rprojectemployee";
		
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			// Set the parameters to the query
			// Execute the insert
			resultset=statement.executeQuery();
			
			while(resultset.next())
			{
				names1.add(resultset.getString(1));
			}

		} catch (SQLException e) {
			
			System.out.println("Error creating cs");
		}

		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			System.out.println("Error closing connection");
		}

		return names1;
	}
}


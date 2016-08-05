package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ViewCustModel;
import java.util.ArrayList;

public class ViewCustDao {
	private Connection connection;
	 //Database connection parameters
	    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
	    private String username = "dbuser";
	    private String password = "db1";
	
	    public ArrayList<String> setCustid(){
		ArrayList<String> names = new ArrayList<String>();
		ResultSet relustset;
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Error creating connection to database");
			System.exit(-1);
		}
		String sql = "select custid from rprojectcustomer";
		
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			relustset=statement.executeQuery();

			while(relustset.next())
			{
				names.add(relustset.getString(1));
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

		return names;
	}
}


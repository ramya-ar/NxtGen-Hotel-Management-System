package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.CreateBillModel;
import model.ViewCustModel;

public class BillCustOKDao {
	
	public ArrayList<String> setCfname() {
		// TODO Auto-generated method stub
		return null;
	}

    private Connection connection;
 //Database connection parameters
    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
    private String username = "dbuser";
    private String password = "db1";
    
public String[] bill(String cfname) throws SQLException{
		
		ResultSet resultset;
		String x="", y="";
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Error creating connection to database");
			System.exit(-1);
		}
		String sql = "select cfname,cphn from rprojectcustomer where cfname=? ";
		
		System.out.println();
		
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			statement.setString(1,cfname);
			resultset=statement.executeQuery();
			
			while(resultset.next())
			{
			resultset.getString(1);
			resultset.getString(2);
			
			CreateBillModel billmodel = new CreateBillModel();
			

			billmodel.setCfname(resultset.getString(1));
			billmodel.setCphn(resultset.getString(2));
			
		    
		    x=resultset.getString(1);
			y = resultset.getString(2);
			
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

		return (new String[]{x,y});
	}
		

}
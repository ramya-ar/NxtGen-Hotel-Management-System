package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.CreateCustModel;
import model.DelCustModel;

public class DelCustDao {
	private  Connection connect;
	private  Statement statement;
	private  ResultSet resultset;
	
    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
    private String username = "dbuser";
    private String password = "db1";
    
    public DelCustModel del(DelCustModel CustModel) 
    {
     //Get a connection
     try {
               connect = DriverManager.getConnection(url, username, password);
         }
     catch(SQLException e) 
     {
               System.out.println("Error creating connection to database: " + e);
     }
     String sql = "DELETE FROM rprojectcustomer where custid =?";
	  try(PreparedStatement statement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
	  {
		  statement.setString(1, CustModel.getCustid());
      statement.executeUpdate();
      System.out.println(statement.getUpdateCount());


	  } catch(SQLException e){
      	CustModel = null;
          System.out.println("Error Creating");
      }
	  
     try {
         connect.close();
         connect = null;
     } catch(SQLException e) {
         System.out.println("Error closing connection");
     }
return CustModel;

    }

}

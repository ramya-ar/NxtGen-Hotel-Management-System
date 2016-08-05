package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DelEmpModel;

public class DelEmpDao {
	
	private  Connection connect;
	private  Statement statement;
	private  ResultSet resultset;
	
    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
    private String username = "dbuser";
    private String password = "db1";
    
    public DelEmpModel del(DelEmpModel EmpModel) 
    {
     //Get a connection
     try {
               connect = DriverManager.getConnection(url, username, password);
         }
     catch(SQLException e) 
     {
               System.out.println("Error creating connection to database");
     }
     
     String sql = "DELETE FROM rprojectemployee where eid =?";
	  try(PreparedStatement statement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
	  {
		  statement.setString(1, EmpModel.getEid());
      statement.executeUpdate();
      System.out.println(statement.getUpdateCount());


	  } catch(SQLException e){
      	EmpModel = null;
          System.out.println("Error Creating");
      }
	  
     try {
         connect.close();
         connect = null;
     } catch(SQLException e) {
         System.out.println("Error closing connection");
     }
return EmpModel;

    }

}

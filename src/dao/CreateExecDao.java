package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ExecModel;


public class CreateExecDao {
	private  Connection connect;
	private  Statement statement;
	private  ResultSet resultset;
	
    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
    private String username = "dbuser";
    private String password = "db1";
   
 public ExecModel create(ExecModel execModel) 
 {
  //Get a connection
  try {
            connect = DriverManager.getConnection(url, username, password);
      }
  catch(SQLException e) 
  {
            System.out.println("Error creating connection to database: " + e);
  }
 
              String sql = "INSERT INTO rprojectexec (efloorno,eroomno,erate) VALUES (?,?,?)";

        	  try(PreparedStatement statement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
        	   //Set the parameters to the query
        	            statement.setString(1, execModel.getEfloor());
        	            statement.setString(2, execModel.getEroomno());
        	            statement.setString(3, execModel.getErate());
        	  //Execute the insert
        	            statement.executeUpdate();
        	            
        	            System.out.println(statement.getUpdateCount());
        	     
        	            } catch(SQLException e){
        	            	execModel = null;
        	            System.out.println("Error Creating");
        	        }
        	  try {
                  connect.close();
                  connect = null;
              } catch(SQLException e) {
                  System.out.println("Error closing connection");
              }
        return execModel;
}

}

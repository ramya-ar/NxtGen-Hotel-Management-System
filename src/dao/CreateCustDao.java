package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import model.CreateCustModel;

public class CreateCustDao {
	
	private  Connection connect;
	private  Statement statement;
	private  ResultSet resultset;
	
    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
    private String username = "dbuser";
    private String password = "db1";
   
    //Saving customer model to database
 public CreateCustModel create(CreateCustModel CustModel) 
 {
  //Get a connection
  try {
            connect = DriverManager.getConnection(url, username, password);
      }
  catch(SQLException e) 
  {
            System.out.println("Error creating connection to database: " + e);
  }
 
           String sql = "INSERT INTO rprojectcustomer (custid,cfname,clname,cphn,caddr) VALUES (?,?,?,?,?)";

        	  //Use prepared statements to avoid SQL injection attacks
        	  try(PreparedStatement statement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
        	   //Set the parameters to the query
        	            statement.setString(1, CustModel.getCustid());
        	            statement.setString(2, CustModel.getCfname());
        	            statement.setString(3, CustModel.getClname());
        	            statement.setString(4, CustModel.getCphn());
        	            statement.setString(5, CustModel.getCaddr());
        	            //Execute the insert
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

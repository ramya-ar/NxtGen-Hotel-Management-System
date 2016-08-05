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
import model.DeluxeModel;

public class CreateDeluxeDao {
	
	private  Connection connect;
	private  Statement statement;
	private  ResultSet resultset;
	
    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
    private String username = "dbuser";
    private String password = "db1";
   
    //Saving customer model to database
 public DeluxeModel create(DeluxeModel DeluxeModel) 
 {
  //Get a connection
  try {
            connect = DriverManager.getConnection(url, username, password);
      }
  catch(SQLException e) 
  {
            System.out.println("Error creating connection to database: " + e);
  }
 
              String sql = "INSERT INTO rprojectdeluxe (dfloor,drromno,drate) VALUES (?,?,?)";

        	  //Use prepared statements to avoid SQL injection attacks
        	  try(PreparedStatement statement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
        	   //Set the parameters to the query
        	            statement.setString(1, DeluxeModel.getDfloor());
        	            statement.setString(2, DeluxeModel.getDroomno());
        	            statement.setString(3, DeluxeModel.getDrate());
        	            //Execute the insert
        	            statement.executeUpdate();
        	            
        	            System.out.println(statement.getUpdateCount());
        	     
        	            } catch(SQLException e){
        	        	DeluxeModel = null;
        	            System.out.println("Error Creating");
        	        }
        	  try {
                  connect.close();
                  connect = null;
              } catch(SQLException e) {
                  System.out.println("Error closing connection");
              }
        return DeluxeModel;
}
}


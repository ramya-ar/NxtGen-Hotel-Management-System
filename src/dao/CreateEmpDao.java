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
import model.CreateEmpModel;

public class CreateEmpDao {
	
	private  Connection connect;
	private  Statement statement;
	private  ResultSet resultset;
	
    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
    private String username = "dbuser";
    private String password = "db1";
    
    public CreateEmpModel create(CreateEmpModel EmpModel) 
    {
     //Get a connection
     try {
               connect = DriverManager.getConnection(url, username, password);
         }
     catch(SQLException e) 
     {
               System.out.println("Error creating connection to database: " + e);
     }
     String sql = "INSERT INTO rprojectemployee (eid,efname,elname,ephn,eaddr) VALUES (?,?,?,?,?)";
     
	  try(PreparedStatement statement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
	   //Set the parameters to the query
	            statement.setString(1, EmpModel.getEid());
	            statement.setString(2, EmpModel.getEfname());
	            statement.setString(3, EmpModel.getElname());
	            statement.setString(4, EmpModel.getEphn());
	            statement.setString(5, EmpModel.getEaddr());
	            //Execute the insert
	            statement.executeUpdate();
	            
	            System.out.println("Rows updated"+statement.getUpdateCount());
	            
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

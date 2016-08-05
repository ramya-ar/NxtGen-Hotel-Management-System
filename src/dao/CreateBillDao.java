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
import model.CreateBillModel;

public class CreateBillDao {
	
	private  Connection connect;
	private  Statement statement;
	private  ResultSet resultset;
	
    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
    private String username = "dbuser";
    private String password = "db1";
   
 public CreateBillModel create(CreateBillModel BillModel) 
 {
  //Get a connection
  try {
            connect = DriverManager.getConnection(url, username, password);
      }
  catch(SQLException e) 
  {
            System.out.println("Error creating connection to database: " + e);
  }
   
              String sql = "INSERT INTO rprojectbill (bid,cfname,cphn,billdate,billamount,discount,billtotal) VALUES (?,?,?,?,?,?,?)";

        	  try(PreparedStatement statement = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
        	   //Set the parameters to the query
        	            statement.setString(1, BillModel.getBid());
        	            statement.setString(2, BillModel.getCfname());
        	            statement.setString(3, BillModel.getCphn());
        	            statement.setString(4, BillModel.getBilldate());
        	            statement.setString(5, BillModel.getBillamount());
        	            statement.setString(6, BillModel.getDiscount());
        	            statement.setString(7, BillModel.getBilltotal());

        	            //Execute the insert
        	            statement.executeUpdate();
        	            
        	            System.out.println("Rows inserted: "+statement.getUpdateCount());
        	            

 Alert alert = new Alert(AlertType.INFORMATION);	 
 alert.setTitle("Information Dialog");
 alert.setHeaderText("Bill Generation");
 alert.setContentText("Bill generated and saved in database");
 alert.showAndWait();  
        	            
        	     
        	            } catch(SQLException e){
        	        	BillModel = null;
        	            System.out.println("Error Creating");
        	        }
        	  try {
                  connect.close();
                  connect = null;
              } catch(SQLException e) {
                  System.out.println("Error closing connection");
              }
        return BillModel;
}
}

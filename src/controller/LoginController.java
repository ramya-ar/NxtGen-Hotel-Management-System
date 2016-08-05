package controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
@FXML
private Label lblpopup;

@FXML
protected TextField txtusername ;

@FXML
protected PasswordField txtpassword ;

@FXML
private Button btnlogin ;


private static Connection connect=null;
private static Statement statement=null;
private static ResultSet resultset=null;

String admin_userstore;
String admin_passstore;
String emp_userstore;
String emp_passstore;

public String un;
public String ps;	
 


public void login(ActionEvent event) throws IOException{
	  try 
	  	{
		  
		  un=txtusername.getText();
		  ps=txtpassword.getText();
		  
		  
			Class.forName("com.mysql.jdbc.Driver");
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://www.papademas.net/inventory?"
		              + "user=dbuser&password=db1");
			
	      	Statement stated=null;
	      	stated=(Statement) connect.createStatement();
	      	String query1 ="select user, passcode from mydb.rprojectlogin where ID='1'";
	      	ResultSet rs1 = stated.executeQuery(query1);
	      	 while (rs1.next()) {
	      		admin_userstore = rs1.getString("user");	           
	      		admin_passstore = rs1.getString("passcode");
	      	 }
	      	 
	      	String query2 ="select user, passcode from mydb.rprojectlogin where ID='2'";
	      	ResultSet rs2 = stated.executeQuery(query2);
	      	 while (rs2.next()) {
	      		emp_userstore = rs2.getString("user");	           
	      		emp_passstore = rs2.getString("passcode");
	      	 }
	      	 
	      
	             if(txtusername.getText().equals(admin_userstore) && txtpassword.getText().equals(admin_passstore)){	         	  
	         		Stage primaryStage= new Stage();
	        		FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/admin.fxml"));
	                AnchorPane root =(AnchorPane) loader.load();
	            	Scene scene = new Scene(root,1000,600);
	            	AdminController ec = loader.getController();
	        		ec.setValues(admin_userstore, admin_passstore);
	        		primaryStage.setScene(scene);
	        		primaryStage.show();
	        		Stage stage = (Stage) btnlogin.getScene().getWindow();
	        		stage.close();
	             }
	      		
	             else if(txtusername.getText().equals(emp_userstore) && txtpassword.getText().equals(emp_passstore)){	         	  
		         		Stage primaryStage= new Stage();
		        		FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/employee.fxml"));
		                AnchorPane root =(AnchorPane) loader.load();
		        		Scene scene = new Scene(root,1000,600);
		        		EmployeeController ec = loader.getController();
		        		ec.setValues(emp_userstore, emp_passstore);
		        		primaryStage.setScene(scene);
		        		primaryStage.show();
		        		Stage stage = (Stage) btnlogin.getScene().getWindow();
		        		stage.close();
		             }
	             
	      	 
	      	 else {
       				lblpopup.setText("Username or Password Incorrect");
        		   }
	         }   
	      	 	
	      	catch(Exception e)
	      	{
	      		
	      		System.out.println("Unble to connect to the database");	
	      	}
	  
	  
	  
}
}
	
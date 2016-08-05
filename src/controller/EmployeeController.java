package controller;

import java.io.IOException;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import controller.CustomerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EmployeeController{
	
	private static Connection connect=null;
	private static Statement statement=null;
	private static ResultSet resultset=null;	
	
@FXML	 	
private Button empCustomer;
@FXML	 	
private Button empBill;
@FXML
private Button empbck;
@FXML
private Button emplogout;

String emp;
String pass;

public void setValues(String emp,String pass)
{
	this.emp = emp;
	this.pass = pass;
}

public void customer(ActionEvent event) throws IOException{
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/customer.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	CustomerController cc = loader.getController();
	cc.setValuesemp(emp,pass);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) empCustomer.getScene().getWindow();
	stage.close();	
}

public void bill(ActionEvent event) throws IOException{
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/bill.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) empBill.getScene().getWindow();
	stage.close();	
}

public void back(ActionEvent event) throws IOException{
	
	
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/admin.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) empbck.getScene().getWindow();
	stage.close();	
}

public void logout(ActionEvent event) throws IOException{
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/Login.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) emplogout.getScene().getWindow();
	stage.close();	
}
	
}
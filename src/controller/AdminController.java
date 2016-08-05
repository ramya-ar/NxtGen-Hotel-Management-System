package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminController {
@FXML	 	
private Button admDeluxe;

@FXML 
private Button admExecutive ;

@FXML
private Button admcust ;

@FXML
private Button admEmployees ;

@FXML
private Button admOffers;

@FXML
private Button admBill;
@FXML
private Button admlogout;

String admin_userstore;
String admin_passstore;

public void setValues(String un,String pass)
{
	this.admin_userstore = un;
	this.admin_passstore = pass;
}

public void deluxe(ActionEvent event) throws IOException{
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/deluxe.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) admDeluxe.getScene().getWindow();
	stage.close();	
}

public void employeepage(ActionEvent event) throws IOException{
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/employeepage.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) admEmployees.getScene().getWindow();
	stage.close();	
}
	
public void executive(ActionEvent event) throws IOException{
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/executive.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) admExecutive.getScene().getWindow();
	stage.close();	
}
public void bill(ActionEvent event) throws IOException{
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/bill.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) admBill.getScene().getWindow();
	stage.close();	
}
public void offers(ActionEvent event) throws IOException{
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/offers.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) admOffers.getScene().getWindow();
	stage.close();	
}
public void customer(ActionEvent event) throws IOException{
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/customer.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	CustomerController cc= loader.getController();
	cc.setValuesamp(admin_userstore, admin_passstore);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) admcust.getScene().getWindow();
	stage.close();	
}

public void logout(ActionEvent event) throws IOException{
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/Login.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) admlogout.getScene().getWindow();
	stage.close();	
}
	
	
	
}


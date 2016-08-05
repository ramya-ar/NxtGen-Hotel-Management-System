package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.CreateCustDao;
import dao.DelCustDao;
import dao.ViewCustDao;
import dao.UpdateCustDao;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import model.CreateCustModel;
import model.DelCustModel;
import model.UpdateCustModel;


public class CustomerController extends LoginController {
@FXML	 	
private Button bkbutton;
@FXML
private Button btncustadd;
@FXML
private Button btncustupd;
@FXML
private Button btncustdel;
@FXML
private Button btncustok;
@FXML
private Button btncustprev;
@FXML
private Button btncustnext;
@FXML
private TextField txtcustid;
@FXML
private TextField txtcustname;
@FXML
private TextField txtcustlastname;
@FXML
private TextField txtcustph;
@FXML
private TextArea txtcustaddress;
@FXML
private Button btncustview;
@FXML
private Label lbls;
@FXML	 	
private Button bkbutton1;


private String user="";
private String pass="";
private String au="";
private String ap="";
private String eu="";
private String ep="";

public void setValuesemp(String ep,String eu)
{
	this.eu = eu;
	this.ep = ep;
	this.user = eu;
	this.pass = ep;

}

public void setValuesamp(String ap,String au)
{
	this.au = au;
	this.ap = ap;
	this.user = au;
	this.pass = ap;

}
public void add(ActionEvent event) throws IOException{
	 
	  String txtcustid = this.txtcustid.getText();
	  String txtcustname = this.txtcustname.getText();
	  String txtcustlastname = this.txtcustlastname.getText();
	  String txtcustph = this.txtcustph.getText();
	  String txtcustaddress = this.txtcustaddress.getText();
	 
	  CreateCustModel createcustModel = new CreateCustModel();
	  createcustModel.setCustid(txtcustid);
	  createcustModel.setCfname(txtcustname);
	  createcustModel.setClname(txtcustlastname);
	  createcustModel.setCphn(txtcustph);
	  createcustModel.setCaddr(txtcustaddress);
	 
	  CreateCustDao b = new CreateCustDao();
	  b.create(createcustModel);
	  Stage stage = (Stage) btncustadd.getScene().getWindow();
	  System.out.println("Data Inserted");
}

public void delete(ActionEvent event) throws IOException{
	String txtcustid = this.txtcustid.getText();
	DelCustModel delcustModel = new DelCustModel();
	delcustModel.setCustid(txtcustid);
	
	DelCustDao b = new DelCustDao();
	b.del(delcustModel);
	Stage stage = (Stage) btncustdel.getScene().getWindow();
	  System.out.println("Data Deleted");
}

public void view(ActionEvent event) throws IOException{
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/viewcustomer.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) btncustview.getScene().getWindow();
	stage.close();	
}

public void update()

{
String 	cid=this.txtcustid.getText();
String 	cfname=this.txtcustname.getText();
String 	clname=this.txtcustlastname.getText();
String 	cphn=this.txtcustph.getText();
String 	caddr=this.txtcustaddress.getText();

UpdateCustModel updatecustModel = new UpdateCustModel();

updatecustModel.setCustid(cid);
updatecustModel.setCfname(cfname);
updatecustModel.setClname(clname);
updatecustModel.setCphn(cphn);
updatecustModel.setCaddr(caddr);

UpdateCustDao updatecustDao= new UpdateCustDao();

updatecustDao.update(updatecustModel);
Stage stage=(Stage) btncustupd.getScene().getWindow();
lbls.setText("Your Data has been Updated Successfully");

}

public void back(ActionEvent event) throws IOException{
	Stage primaryStage= new Stage();
	if(user.equals(au)&& pass.equals(ap)){	
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/admin.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) bkbutton.getScene().getWindow();
	stage.close();	
}

	else if(user.equals(eu)&& pass.equals(ep))
	{	         	  
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/employee.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) bkbutton.getScene().getWindow();
	stage.close();	
}
	else 
	{
		System.out.println(user + pass);
		
	}
}

}

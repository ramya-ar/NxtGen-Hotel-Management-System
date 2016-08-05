package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import dao.CreateDeluxeDao;
import dao.DelDeluxeDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.CreateBillModel;
import model.DelCustModel;
import model.DeluxeModel;

public class DeluxeController implements Initializable {
	
	private static Connection connect=null;
	private static Statement statement=null;
	private static ResultSet resultset=null;
	
@FXML	 	
private Button bkbutton;
@FXML	 	
private Button btndeluxeadd;
@FXML	 	
private Button btndeluxedel;
@FXML	 	
private Button btndeluxeok;
@FXML	 	
private TextField txtdeluxermno;
@FXML	 	
private TextField txtdeluxerate;
@FXML
private ComboBox <String> deluxefloorcmbx;

ObservableList <String> cmbxlist=FXCollections.observableArrayList("Floor-1","Floor-2","Floor-3","Floor-4","Floor-5");

public void initialize(URL url, ResourceBundle rb) {	
	deluxefloorcmbx.setValue("Floor-1");
	deluxefloorcmbx.setItems(cmbxlist);
}


public void add(ActionEvent event) throws IOException{
	
	  String deluxefloorcmbx = this.deluxefloorcmbx.getValue();
	  String txtdeluxermno = this.txtdeluxermno.getText();
	  String txtdeluxerate = this.txtdeluxerate.getText();
	 
	  DeluxeModel deluxemodel = new DeluxeModel();
	  deluxemodel.setDfloor(deluxefloorcmbx);
	  deluxemodel.setDroomno(txtdeluxermno);
	  deluxemodel.setDrate(txtdeluxerate);


	  CreateDeluxeDao b = new CreateDeluxeDao();
	  b.create(deluxemodel);
	  Stage stage = (Stage) btndeluxeadd.getScene().getWindow();
	  System.out.println("Data Inserted");
}

public void delete(ActionEvent event) throws IOException{
	String txtdeluxermno = this.txtdeluxermno.getText();
	DeluxeModel delModel = new DeluxeModel();
	delModel.setDroomno(txtdeluxermno);
	
	DelDeluxeDao b = new DelDeluxeDao();
	b.del(delModel);
	Stage stage = (Stage) btndeluxedel.getScene().getWindow();
	  System.out.println("Data Deleted");
}


public void back(ActionEvent event) throws IOException{
	
	
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/admin.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) bkbutton.getScene().getWindow();
	stage.close();	
}	
}


package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import dao.CreateExecDao;
import dao.DelExecDao;
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
import model.ExecModel;

public class ExecutiveController implements Initializable{
	
	private static Connection connect=null;
	private static Statement statement=null;
	private static ResultSet resultset=null;
	
@FXML	 	
private Button bkbutton;
@FXML	 	
private Button btnexecadd;
@FXML	 	
private Button btnexecdel;
@FXML	 	
private Button btnexecupd;
@FXML	 	
private Button execPrev;
@FXML	 	
private Button execNext;
@FXML	 	
private Button btnexecok;
@FXML	 	
private TextField txtexecrmno;
@FXML	 	
private TextField txtexecrate;
@FXML
private ComboBox <String> execfloorcmbx;


ObservableList <String> cmbxlist=FXCollections.observableArrayList("Floor-1","Floor-2","Floor-3","Floor-4","Floor-5");

public void initialize(URL url, ResourceBundle rb) {	
	execfloorcmbx.setValue("Floor-1");
	execfloorcmbx.setItems(cmbxlist);
}


public void add(ActionEvent event) throws IOException{
	
	  String execfloorcmbx = this.execfloorcmbx.getValue();
	  String txtexecrmno = this.txtexecrmno.getText();
	  String txtexecrate = this.txtexecrate.getText();
	 
	  ExecModel execmodel = new ExecModel();
	  execmodel.setEfloor(execfloorcmbx);
	  execmodel.setEroomno(txtexecrmno);
	  execmodel.setErate(txtexecrate);


	  CreateExecDao b = new CreateExecDao();
	  b.create(execmodel);
	  Stage stage = (Stage) btnexecadd.getScene().getWindow();
	  System.out.println("Data Inserted");
}

public void delete(ActionEvent event) throws IOException{
	String txtexecrmno = this.txtexecrmno.getText();
	ExecModel delModel = new ExecModel();
	delModel.setEroomno(txtexecrmno);
	
	DelExecDao b = new DelExecDao();
	b.del(delModel);
	Stage stage = (Stage) btnexecdel.getScene().getWindow();
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


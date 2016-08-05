
package controller;

import java.io.IOException;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import dao.CreateCustDao;
import dao.CreateEmpDao;
import dao.DelCustDao;
import dao.DelEmpDao;
import dao.UpdateCustDao;
import dao.UpdateEmpDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.CreateEmpModel;
import model.DelCustModel;
import model.DelEmpModel;
import model.UpdateCustModel;
import model.UpdateEmpModel;

public class EmployeepageController{
	
@FXML	 	
private Button bkbutton;
@FXML
private Button btnempageadd;
@FXML
private Button btnempageupd;
@FXML
private Button btnempagedel;
@FXML
private Button btnempview;
@FXML
private Button btnempageok;
@FXML
private Button btnempageprev;
@FXML
private Button btnempagenext; 
@FXML
private TextField txtempageid;
@FXML
private TextField txtempagename;
@FXML
private TextField txtempagelstnm;
@FXML
private TextField txtempageph;
@FXML
private TextArea txtempageaddress;
@FXML
private Label lbls1;

private static Connection connect=null;
private static Statement statement=null;
private static ResultSet resultset=null;


public void add(ActionEvent event) throws IOException{
	
	 String txtempageid = this.txtempageid.getText();
	 String txtempagename = this.txtempagename.getText();
	  String txtempagelstnm = this.txtempagelstnm.getText();
	  String txtempageph = this.txtempageph.getText();
	  String txtempageaddress = this.txtempageaddress.getText();
	 
	  CreateEmpModel createempModel = new CreateEmpModel();
	  createempModel.setEid(txtempageid);
	  createempModel.setEfname(txtempagename);
	  createempModel.setElname(txtempagelstnm);
	  createempModel.setEphn(txtempageph);
	  createempModel.setEaddr(txtempageaddress);
	 
	  CreateEmpDao b = new CreateEmpDao();
	  b.create(createempModel);
	  Stage stage = (Stage) btnempageadd.getScene().getWindow();
	  System.out.println("Data Inserted");
}

public void delete(ActionEvent event) throws IOException{
	String txtempageid = this.txtempageid.getText();
	DelEmpModel delEmpModel = new DelEmpModel();
	delEmpModel.setEid(txtempageid);
	
	DelEmpDao b = new DelEmpDao();
	b.del(delEmpModel);
	Stage stage = (Stage) btnempagedel.getScene().getWindow();
	  System.out.println("Data Deleted");
}
public void view(ActionEvent event) throws IOException{
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/viewemployee.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) btnempview.getScene().getWindow();
	stage.close();	
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
public void update()

{
String 	eid=this.txtempageid.getText();
String 	efname=this.txtempagename.getText();
String 	elname=this.txtempagelstnm.getText();
String 	ephn=this.txtempageph.getText();
String 	eaddr=this.txtempageaddress.getText();

UpdateEmpModel updateempModel = new UpdateEmpModel();

updateempModel.setEid(eid);
updateempModel.setEfname(efname);
updateempModel.setElname(elname);
updateempModel.setEphn(ephn);
updateempModel.setEaddr(eaddr);

UpdateEmpDao updateempDao= new UpdateEmpDao();

updateempDao.update(updateempModel);
Stage stage=(Stage) btnempageupd.getScene().getWindow();
lbls1.setText("Your Data has been Updated Successfully");

}
}


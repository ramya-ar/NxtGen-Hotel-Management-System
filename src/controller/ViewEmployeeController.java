package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.UpdateEmpDao;
import dao.ViewEmpDao;
import dao.ViewEmpOK;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.UpdateEmpModel;
import model.ViewEmpModel;

public class ViewEmployeeController implements Initializable {
	
	@FXML
	private ComboBox <String> cmbxselemp;
	@FXML
	private Button selempOK;
	
	@FXML
	private TextField e1;
	@FXML
	private TextField e2;
	@FXML
	private TextField e3;
	@FXML
	private TextField e4;
	@FXML
	private TextField e5;
	
	@FXML 
	private Label lbls1;
	
	@FXML 
	private Button btnempupd;
	@FXML
	private Button empviewbck;
	
	private StageStyle dialogStage;
	private Stage stag1 = new Stage();
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		ViewEmpDao db1 = new ViewEmpDao();
		ArrayList<String> ar1 = db1.setEid();
		ObservableList<String> options1 = (ObservableList<String>) FXCollections.observableArrayList(ar1);
		cmbxselemp.setItems(options1);
}
	public void ok()
	{
		try{
			String dispemp =this.cmbxselemp.getValue();
			ViewEmpModel viewempmodel= new ViewEmpModel();
			viewempmodel.setEid(dispemp);
			ViewEmpOK db = new ViewEmpOK();
			String [] x = db.emp(dispemp);
			e1.setText(x[0]);
			e2.setText(x[1]);
			e3.setText(x[2]);
			e4.setText(x[3]);
			e5.setText(x[4]);
			
		}
		catch (Exception e){
			System.out.println();
		}
	}

	public void back(ActionEvent event) throws IOException{
		Stage primaryStage= new Stage();
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/employeepage.fxml"));
	    AnchorPane root =(AnchorPane) loader.load();
		Scene scene = new Scene(root,1000,600);
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage stage = (Stage) empviewbck.getScene().getWindow();
		stage.close();	
	}
	public void update()

	{
	String 	eid=this.e1.getText();
	String 	efname=this.e2.getText();
	String 	elname=this.e3.getText();
	String 	ephn=this.e4.getText();
	String 	eaddr=this.e5.getText();

	UpdateEmpModel updateempModel = new UpdateEmpModel();

	updateempModel.setEid(eid);
	updateempModel.setEfname(efname);
	updateempModel.setElname(elname);
	updateempModel.setEphn(ephn);
	updateempModel.setEaddr(eaddr);

	UpdateEmpDao updateempDao= new UpdateEmpDao();

	updateempDao.update(updateempModel);
	Stage stage=(Stage) btnempupd.getScene().getWindow();
	lbls1.setText("Your Data has been Updated Successfully");
	System.out.println("Data Updated");
}
}

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.UpdateCustDao;
import dao.ViewCustDao;
import dao.ViewCustOkDao;
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
import model.UpdateCustModel;
import model.ViewCustModel;

public class ViewCustomerController implements Initializable {
	
	@FXML
	private ComboBox <String> cmbxselcust;
	@FXML
	private Button selcustOK;
	
	@FXML
	private TextField t1;
	@FXML
	private TextField t2;
	@FXML
	private TextField t3;
	@FXML
	private TextField t4;
	@FXML
	private TextField t5;
	
	@FXML 
	private Label lbls;
	
	@FXML 
	private Button btncustupd;
	@FXML
	private Button btnviewbck;
	
	private StageStyle dialogStage;
	private Stage stag = new Stage();
	
	public void initialize(URL url, ResourceBundle rb) {
		ViewCustDao db = new ViewCustDao();
		ArrayList<String> ar = db.setCustid();
		ObservableList<String> options = (ObservableList<String>) FXCollections.observableArrayList(ar);
		cmbxselcust.setItems(options);
		
	}
	
			public void ok()
	{
		try{
			String dispcust =this.cmbxselcust.getValue();
			ViewCustModel viewcustmodel= new ViewCustModel();
			viewcustmodel.setCustid(dispcust);
			ViewCustOkDao db = new ViewCustOkDao();
			String [] x = db.cust(dispcust);

			t1.setText(x[0]);
			t2.setText(x[1]);
			t3.setText(x[2]);
			t4.setText(x[3]);
			t5.setText(x[4]);
		}
		catch (Exception e){
			System.out.println(e+"");
		}
	}
	
	public void back(ActionEvent event) throws IOException{
		Stage primaryStage= new Stage();
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/customer.fxml"));
	    AnchorPane root =(AnchorPane) loader.load();
		Scene scene = new Scene(root,1000,600);
		primaryStage.setScene(scene);
		primaryStage.show();
		Stage stage = (Stage) btnviewbck.getScene().getWindow();
		stage.close();	
	}
	public void update()

	{
	String 	cid=this.t1.getText();
	String 	cfname=this.t2.getText();
	String 	clname=this.t3.getText();
	String 	cphn=this.t4.getText();
	String 	caddr=this.t5.getText();

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
	System.out.println("Data Updated");
}
}
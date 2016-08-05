package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import model.CreateBillModel;
import model.CreateEmpModel;
import dao.BillCustComboDao;
import dao.BillCustOKDao;
import dao.CreateBillDao;
import dao.CreateEmpDao;
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
import javafx.stage.StageStyle;
import model.CreateBillModel;
import model.ViewCustModel;

public class BillController implements Initializable {
	
	private static Connection connect=null;
	private static Statement statement=null;
	private static ResultSet resultset=null;
	

@FXML	 	
private Button bkbutton;
@FXML	 	
private Button btnbilladd;
@FXML	 	
private Button btnbilldel;
@FXML	 	
private Button btnbillupd;
@FXML	 	
private Button btnbillprev;
@FXML	 	
private Button btnbillnxt;
@FXML	 	
private Button btnbillok;
@FXML
private TextField txtbillid;
@FXML	
private TextField txtbilcustname;
@FXML	 	
private TextArea txtbilladdress;
@FXML	 	
private TextField txtbillphno;
@FXML
private ComboBox <String> cmbxbillcoupon;
@FXML 
private TextField billdate;
@FXML 
private TextField totalbill;
@FXML 
private TextField billamount;
@FXML	 	
private Button couponok;
@FXML
private ComboBox <String> cmbxselcustbill;
int tot=0;
ObservableList <String> cmbxcustlist=FXCollections.observableArrayList("25%-Discount","50%-Discount","75%-Discount","No coupon");

private StageStyle dialogStage;
private Stage stag = new Stage();

public void initialize(URL url, ResourceBundle rb) {	
	
	cmbxbillcoupon.setValue("50%-Discount");
	cmbxbillcoupon.setItems(cmbxcustlist);
	BillCustComboDao db = new BillCustComboDao();
	ArrayList<String> ar = db.setCfname();
	ObservableList<String> options = (ObservableList<String>) FXCollections.observableArrayList(ar);
	cmbxselcustbill.setItems(options);
}

public void ok()
{
	try{
		String dispcust =this.cmbxselcustbill.getValue();
		CreateBillModel viewbillmodel= new CreateBillModel();
		viewbillmodel.setCfname(dispcust);
		BillCustOKDao db = new BillCustOKDao();
		String [] x = db.bill(dispcust);
		txtbilcustname.setText(x[0]);
		txtbillphno.setText(x[1]);
	}
	catch (Exception e){
		System.out.println(e+"");
	}
}

public void add(ActionEvent event) throws IOException{
	
	  String txtbillid = this.txtbillid.getText();
	  String txtbilcustname = this.txtbilcustname.getText();
	  String txtbillphno = this.txtbillphno.getText();
	  String cmbxbillcoupon = this.cmbxbillcoupon.getValue();
	  String billdate = this.billdate.getText();
	 
	  CreateBillModel createbillModel = new CreateBillModel();
	  createbillModel.setBid(txtbillid);
	  createbillModel.setCfname(txtbilcustname);
	  createbillModel.setCphn(txtbillphno);
	  createbillModel.setDiscount(cmbxbillcoupon);
	  createbillModel.setBilldate(billdate);

	  CreateBillDao b = new CreateBillDao();
	  b.create(createbillModel);
	  Stage stage = (Stage) btnbilladd.getScene().getWindow();
	  System.out.println("Data Inserted");
}

public void billok(ActionEvent event) throws IOException{
	
	String amt=billamount.getText();
	String cmbxbillcoupon = this.cmbxbillcoupon.getValue();
	
	int amt1=Integer.parseInt(amt);
	
	if(cmbxbillcoupon.equals("25%-Discount"))
			{
		     tot=(int) (0.75*amt1);
			}
	else if(cmbxbillcoupon.equals("50%-Discount"))
	        {
             tot=(int) (0.5*amt1);
	        }
	else if(cmbxbillcoupon.equals("75%-Discount")) 
	        {
             tot=(int) (0.25*amt1);		     	
	        }
	
	else
	{
		tot=amt1;
	}
	
	String tot1=Integer.toString(tot);
	totalbill.setText(tot1);
	
}


public void back(ActionEvent event) throws IOException{
	
	
	Stage primaryStage= new Stage();
	FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/employee.fxml"));
    AnchorPane root =(AnchorPane) loader.load();
	Scene scene = new Scene(root,1000,600);
	primaryStage.setScene(scene);
	primaryStage.show();
	Stage stage = (Stage) bkbutton.getScene().getWindow();
	stage.close();	
}	
}


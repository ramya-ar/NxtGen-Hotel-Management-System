package model;

import javafx.scene.control.DatePicker;

public class CreateBillModel {
	
	private String bid;
	private String cfname;
	private String cphn;
	private String discount;
    private String billdate;	
    private String billamount;
	private String billtotal;
	
	public CreateBillModel(){
	}
	
	
	public CreateBillModel(String bid,String cfname,String cphn,String billdate,String billamount,String discount, String billtotal){
		this.bid=bid;
		this.cfname=cfname;
		this.cphn=cphn;
		this.discount=discount;
		this.billdate=billdate;
		this.billamount=billamount;
		this.billtotal=billtotal;
	}

    
    public String getBillamount() {
		return billamount;
	}


	public void setBillamount(String billamount) {
		this.billamount = billamount;
	}


	public String getBilltotal() {
		return billtotal;
	}


	public void setBilltotal(String billtotal) {
		this.billtotal = billtotal;
	}
	
	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getCfname() {
		return cfname;
	}

	public void setCfname(String cfname) {
		this.cfname = cfname;
	}

	public String getCphn() {
		return cphn;
	}

	public void setCphn(String cphn) {
		this.cphn = cphn;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getBilldate() {
		return billdate;
	}

	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}



}

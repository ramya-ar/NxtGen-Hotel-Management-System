package model;

public class ViewCustModel {
	private String custid;
	private String cfname;
	private String clname;
	private String cphn;
	private String caddr;
	
	

	//Fully parameterized constructor
	public ViewCustModel(String custid,String cfname,String clname,String cphn,String caddr) {
	this.custid=custid;
	this.cfname = cfname;
	this.clname = clname;
	this.cphn = cphn;
	this.caddr = caddr;
	}
	
	public ViewCustModel()	{
	}
	
	
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getCfname() {
		return cfname;
	}
	public void setCfname(String cfname) {
		this.cfname = cfname;
	}
	public String getClname() {
		return clname;
	}
	public void setClname(String clname) {
		this.clname = clname;
	}
	public String getCphn() {
		return cphn;
	}
	public void setCphn(String cphn) {
		this.cphn = cphn;
	}
	public String getCaddr() {
		return caddr;
	}
	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}
	
}

package model;

public class DelCustModel {
	private String custid;
	
	public DelCustModel()	{
	}
	public DelCustModel(String custid){
		this.custid=custid;
}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
}
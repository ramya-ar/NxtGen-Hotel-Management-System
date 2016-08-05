package model;

public class ExecModel {
	
	String efloor;
	String eroomno;
    String erate;


public ExecModel(){
}

public ExecModel(String efloor, String eroomno, String erate)
{
	this.efloor=efloor;
	this.eroomno=eroomno;
	this.erate=erate;
}

public String getEfloor() {
	return efloor;
}

public void setEfloor(String efloor) {
	this.efloor = efloor;
}

public String getEroomno() {
	return eroomno;
}

public void setEroomno(String eroomno) {
	this.eroomno = eroomno;
}

public String getErate() {
	return erate;
}

public void setErate(String erate) {
	this.erate = erate;
}

}

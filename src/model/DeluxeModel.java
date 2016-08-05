package model;

public class DeluxeModel {
	
	String dfloor;
	String droomno;
    String drate;


public DeluxeModel(){
}

public DeluxeModel(String dfloor, String droomno, String drate)
{
	this.dfloor=dfloor;
	this.droomno=droomno;
	this.drate=drate;
}

public String getDfloor() {
	return dfloor;
}

public void setDfloor(String dfloor) {
	this.dfloor = dfloor;
}

public String getDroomno() {
	return droomno;
}

public void setDroomno(String droomno) {
	this.droomno = droomno;
}

public String getDrate() {
	return drate;
}

public void setDrate(String drate) {
	this.drate = drate;
}
}
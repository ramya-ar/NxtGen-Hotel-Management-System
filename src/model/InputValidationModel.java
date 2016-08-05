package model;

import javafx.scene.control.*;

public class InputValidationModel {
	public static boolean textFieldNotEmpty(TextField tf){
		boolean res=false;
		if(tf.getText()!=null && !tf.getText().isEmpty()){
			res=true;
		}
		return res;
	}
	public static boolean textFieldNotEmpty(TextField tf, Label i,String sValidationText){
		
		boolean res=true;
		String c=null;
		if(!textFieldNotEmpty(tf)){
			res=false;
			c=sValidationText;
		}
		i.setText(c);
		return res;
	}

}
package control;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import vista.V_ModProyect;

public class modBtnListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		V_ModProyect modProyWindow = new V_ModProyect();
		modProyWindow.setVisible(true);

//      JTextField nameTxtF = modProyWindow.getNameTxtF();
//      JTextField lastNameTxtF = modProyWindow.getLastNamesTxtF();
        //Termonar de crear y guardar el resto de fields 
//      String editedName = nameTxtF.getText();
//      String editedLastNames = lastNameTxtF.getText();
        
//      Actualizar al estudiante con la base de dato
	}
	}

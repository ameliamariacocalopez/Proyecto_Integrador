package control;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import vista.AddAlumn;

public class EditStdntBtnListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		AddAlumn editStudentWindow = new AddAlumn();
        editStudentWindow.setVisible(true);

    	JTextField numExpTxtF = editStudentWindow.getNumExpTxtF();
    	JTextField codigoTxtF = editStudentWindow.getCodigoTxtF();
    	JTextField nombreTxtF = editStudentWindow.getNombreTxtF();
    	JTextField apellidosTxtF = editStudentWindow.getApellidosTxtF();
    	
        String editedID = numExpTxtF.getText();
        String editedNombre = codigoTxtF.getText();
        String editedUrl = nombreTxtF.getText();
        String editedNota = apellidosTxtF.getText();
            
//      Actualizar al estudiante
//      ------------------------
	}
}

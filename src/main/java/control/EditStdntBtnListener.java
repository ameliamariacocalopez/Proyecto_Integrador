package control;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import modelo.AccesoBBDD;
import modelo.Alumno;
import vista.AddAlumn;
import vista.AlumnProyect;

public class EditStdntBtnListener implements ActionListener {

	AddAlumn vista;
	AccesoBBDD programa;

	public EditStdntBtnListener(AddAlumn addAlumn) {
		// TODO Auto-generated constructor stub
		vista = addAlumn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Alumno alumno = vista.getAlumno();
		String idProyect = vista.getIdProyectoSeleccionado();
		if (idProyect.length() > 0) {

			ArrayList<String> matriculas = new ArrayList<>();
			matriculas.add("" + alumno.getNumExpediente());

			programa = new AccesoBBDD();
			programa.getConexion();
			programa.meterAlumnosEnProyecto(idProyect, matriculas);

			JOptionPane.showMessageDialog(vista, "Alumno mdificado, nuevo proyecto = " + idProyect);

		}
	}
//	private AlumnProyect v;
//	
//	public EditStdntBtnListener (AlumnProyect vista) {
//		this.v = vista;
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		AlumnProyect editStudentWindow = new AlumnProyect();
//        editStudentWindow.setVisible(true);
//
//        
////    	JTextField numExpTxtF = editStudentWindow.getNumExpTxtF();
////    	JTextField codigoTxtF = editStudentWindow.getCodigoTxtF();
////    	JTextField nombreTxtF = editStudentWindow.getNombreTxtF();
////    	JTextField apellidosTxtF = editStudentWindow.getApellidosTxtF();
//    	
////        String editedID = numExpTxtF.getText();
////        String editedNombre = codigoTxtF.getText();
////        String editedUrl = nombreTxtF.getText();
////        String editedNota = apellidosTxtF.getText();
//	}
//	
//	public boolean valuesRepetidas(ArrayList<Alumno> alumnosList) {
//	    boolean repetidas = false;
////	    String nombre = v.getNombreTxtF().getText();
////	    String apellidos = v.getApellidosTxtF().getText();
////
////	    for (Alumno alumno : alumnosList) {
////	        if (alumno.getNombre().equals(nombre) && alumno.getApellidos().equals(apellidos)) {
////	            repetidas = true;
////	            break;
////	        }
////	    }
////
//	    return repetidas;
//	}
}
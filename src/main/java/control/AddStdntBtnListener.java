package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;

import modelo.AccesoBBDD;
import modelo.Alumno;
import modelo.ProyectoIntegrador;
import vista.AddAlumn;
import vista.AlumnProyect;
import vista.OpenConsulProy;

public class AddStdntBtnListener implements ActionListener {
	private JList<String> projectList;
    ArrayList<ProyectoIntegrador> listaProyectos;

	AccesoBBDD programa = new AccesoBBDD();
	AlumnProyect v;
	AddAlumn a;
	
	public AddStdntBtnListener(AlumnProyect vista) {
		v = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedAlumnn = v.getAlumno();
		if (selectedAlumnn != null) {
			System.out.println("Alumno: " + selectedAlumnn);
//			int posicionGuion = selectedAlumnn.indexOf('-');
//			String nombreAlumno = selectedAlumnn.substring(0, posicionGuion);
//			nombreAlumno = nombreAlumno.trim();
//			System.out.println("Nombre de alumno ->" + nombreAlumno + "<-");
			programa.getConexion();
			
			//devuelva los datos de UN alumno
			Alumno alumno = programa.alumnoSeleccionado(selectedAlumnn);

			// Crea una instancia de la ventana de modificación de proyecto
			a = new AddAlumn(alumno);

			// Establece los valores de los campos de la ventana de detalles del proyecto
			a.getidTxtF().setText(""+alumno.getIdProyecto());
			a.getNumExpTxtF().setText(""+alumno.getNumExpediente());
			a.getNombreTxtF().setText(alumno.getNombre());
			a.getApellidosTxtF().setText(alumno.getApellidos());			
			
			
			listaProyectos = programa.cargarProyectos("Select * from proyectointegrador");
			//muestra la lista
        	a.showProjects(listaProyectos);

			
			// Hace visible la ventana de modificación de proyecto
			a.hacerVisible();

		} else {
			System.out.println("No hay ningún proyecto seleccionado.");
		}
	}
}
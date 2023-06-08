package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import modelo.AccesoBBDD;
import modelo.ProyectoIntegrador;
import vista.ConsulProyect;
import vista.OpenConsulProy;

public class ConsulBtnListener implements ActionListener {
	private JList<String> projectList;
	
	AccesoBBDD programa = new AccesoBBDD();
	OpenConsulProy projectDetailsWindow;// = new OpenConsulProy();

	/**
	 * Constructor de la clase ConsulBtnListener.
	 * 
	 * @param projectList el componente JList que contiene los proyectos.
	 */
	public ConsulBtnListener(JList<String> projectList) {
		this.projectList = projectList;
	}

	/**
	 * Maneja el evento de acciÃ³n desencadenado por un clic en un botÃ³n.
	 * 
	 * @param e el objeto ActionEvent que representa el evento.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// recoge el item seleccionado
		String selectedProject = projectList.getSelectedValue();
		if (selectedProject != null) {
			System.out.println("Proyecto seleccionado: " + selectedProject);
			int posicionGuion = selectedProject.indexOf('-');
			String nombreProyecto = selectedProject.substring(0, posicionGuion);
			nombreProyecto = nombreProyecto.trim();
			System.out.println("Nombre de proyecto ->" + nombreProyecto + "<-");

			
			ProyectoIntegrador proyectoSeleccionado = new ProyectoIntegrador();
			programa.getConexion();
			proyectoSeleccionado = programa.obtenerDatosProyectoDesdeBD(nombreProyecto);
			
			// Crea una instancia de la ventana de modificaciÃ³n de proyecto
			projectDetailsWindow = new OpenConsulProy();

			// Establece los valores de los campos de la ventana de detalles del proyecto
			projectDetailsWindow.getIdTxtF().setText(proyectoSeleccionado.getIdProyecto());
			projectDetailsWindow.getNombreProyTxtF().setText(proyectoSeleccionado.getNombreProyecto());
			projectDetailsWindow.getUrlTxtF().setText(proyectoSeleccionado.getUrlProyecto());
			projectDetailsWindow.getNotaTxtF().setText(proyectoSeleccionado.getNota());
			projectDetailsWindow.getFechaTxtF().setText(proyectoSeleccionado.getFecha());
			projectDetailsWindow.getCursoTxtF().setText(proyectoSeleccionado.getCurso());
			projectDetailsWindow.getAreaTxtF().setText(proyectoSeleccionado.getAreaCorrespondiente());
			
			// Hace visible la ventana de modificaciÃ³n de proyecto
			projectDetailsWindow.hacerVisible();

		} else {
			System.out.println("No hay ningún proyecto seleccionado.");
		}

		// AquÃ­ no recogemos el TextField, recogemos los datos de la BBDD

	}
}
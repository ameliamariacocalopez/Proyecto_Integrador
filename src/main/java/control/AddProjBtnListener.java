package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.AccesoBBDD;
import modelo.Alumno;
import vista.AddProyect;

/**
 * Clase que implementa ActionListener para el botÃ³n de agregar proyecto en la
 * vista AddProyect.
 */
public class AddProjBtnListener implements ActionListener {
	private AddProyect v;
	AccesoBBDD programa = new AccesoBBDD();

	/**
	 * Constructor de la clase AddProjBtnListener.
	 * 
	 * @param vista La instancia de AddProyect a la que se asocia este listener.
	 */
	public AddProjBtnListener(AddProyect vista) {
		this.v = vista;
	}

	/**
	 * MÃ©todo que se invoca cuando se produce un evento de acciÃ³n.
	 * @param e El evento de acciÃ³n.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Si hay mÃ¡s de un alumno vacÃ­o, sale diÃ¡logo de error. Si no, se ejecuta el resto del mÃ©todo
		if (v.getEstudiante1().equals("--") && v.getEstudiante2().equals("--") && v.getEstudiante3().equals("--")) {
			JOptionPane.showMessageDialog(v, "Hace falta añadir como mínimo un alumno.");
		} else {
			if (programa.proyectoRepetido(v.getName())) {
				// Muestra un mensaje si el proyecto ya existe en la base de datos
				JOptionPane.showMessageDialog(v, "Proyecto ya existente.");
			} else if (v.getRes1() == null && v.getRes2() == null && v.getRes4() == null && v.getRes5() == null && v.getRes6() == null && v.getRes7() == null && v.getRes8() == null && v.getRes9() == null) {
				// Muestra un mensaje si no se han completado todos los campos en la vista
				JOptionPane.showMessageDialog(v, "Por favor, rellena todos los campos.");
			} else {
				// Verifica si el proyecto estÃ¡ repetido
				insertProy();
			}
		}
	}

	/**
	 * Inserta un nuevo proyecto en la base de datos.
	 */
	public void insertProy() {
		// a la hora de aÃ±adir los alumnos hay que comprobar que el dato conseguido de
		// la vista no es --

		// Obtiene los valores de los campos de la vista AddProyect
		String t1 = v.getRes1().getText().trim();
		String t2 = v.getRes2().getText().trim();
		String t4 = v.getRes4().getText().trim();
		String t5 = v.getRes5().getText().trim();
		String t6 = v.getRes6().getText().trim();
		String t7 = v.getRes7().getText().trim();
		String t8 = v.getRes8().getText().trim();
		String t9 = (String) v.getRes9().getSelectedItem();

		// Establece los valores en el objeto AccesoBBDD
		programa.setId(t1);
		programa.setNombre(t2);
		programa.setUrlP(t4);
		programa.setNota(t5);
		programa.setFecha(t6);
		programa.setCurso(t7);
		programa.setGrupo(t8);
		if (t9.equals("DAM")) {
			programa.setArea(1);
		} else if (t9.equals("DAW")) {
			programa.setArea(2);
		} else if (t9.equals("ASIR")) {
			programa.setArea(3);
		} else {
			System.out.print("Error");
		}

		programa.getConexion();
		boolean resultado = programa.proyectoNuevo();

		if (resultado) {
			// Muestra mensajes de confirmaciÃ³n o error segÃºn el resultado de la inserciÃ³n del proyecto
			JOptionPane.showMessageDialog(v, "Proyecto añadido.");
		} else {
			JOptionPane.showMessageDialog(v, "Error al guardar proyecto.");
		}

	}
}

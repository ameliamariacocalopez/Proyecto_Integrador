package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import modelo.AccesoBBDD;
import modelo.Alumno;
import modelo.ProyectoIntegrador;
import vista.AddProyect;
import vista.AlumnProyect;
import vista.V_ModProyect;

public class saveProyBtnListener implements ActionListener {

	private V_ModProyect v_ModProyect;
	AccesoBBDD programa = new AccesoBBDD();

	public saveProyBtnListener(vista.V_ModProyect v_ModProyect) {
		this.v_ModProyect = v_ModProyect;

	}

	public void actionPerformed(ActionEvent e) {
		programa.getConexion();
		if (v_ModProyect != null) {

			ProyectoIntegrador proyectoACambiar = v_ModProyect.getProyectoSeleccionado();

			String id = v_ModProyect.getIdTxtF().getText();
			String nombre = v_ModProyect.getNombreProyTxtF().getText();
			String urlP = v_ModProyect.getUrlTxtF().getText();
			String nota = v_ModProyect.getNotaTxtF().getText();
			String fecha = v_ModProyect.getFechaTxtF().getText();
			String curso = v_ModProyect.getCursoTxtF().getText();
//			String grupo = v_ModProyect.getGrupoTxtF().getText();

			if (!nota.equals(proyectoACambiar.getNota())) {
				proyectoACambiar.setUrlProyecto(nota);
			}
			if (!urlP.equals(proyectoACambiar.getUrlProyecto())) {
				proyectoACambiar.setUrlProyecto(urlP);
			}

			boolean resultado = programa.guardarCambiosProyecto(proyectoACambiar);

			// ALUMNOS
			// coges los alumnos que están seleccionados en pantalla
			// actualizas el proyecto de esos alumnos
			String estudiante1 = (String) v_ModProyect.getComboBoxEstudiantes().getSelectedItem();
			String estudiante2 = (String) v_ModProyect.getComboBoxEstudiantes2().getSelectedItem();
			String estudiante3 = (String) v_ModProyect.getComboBoxEstudiantes3().getSelectedItem();

			System.out.println(estudiante1 + " / " + estudiante2 + " / " + estudiante3);

			ArrayList<String> matriculasList = new ArrayList<>();
			if (!estudiante1.equals("--")) {
				matriculasList.add(getMatricula(estudiante1));
			}
			if (!estudiante2.equals("--")) {
				matriculasList.add(getMatricula(estudiante2));
			}
			if (!estudiante3.equals("--")) {
				matriculasList.add(getMatricula(estudiante3));
			}
			programa.getConexion();

			ArrayList<String> matriculasAnteriores = new ArrayList<String>();
			for (Alumno a : v_ModProyect.getListaAlumnos()) {
				matriculasAnteriores.add("" + a.getNumExpediente());
			}

			programa.meterAlumnosEnProyecto("-1", matriculasAnteriores);

			programa.meterAlumnosEnProyecto(id, matriculasList);

		}
	}

	public String getMatricula(String alumno) {

		return alumno.substring(0, alumno.indexOf('-')).trim();

	}
}

// Falta:
/*
 * Coger las matrículas de los alumnos de los combobox. Esto hay un método en
 * AlumnProyect que lo hace, y en AddProyect hay tres (getEstudiante1...)
 * Tendrías que tenerlo igual en v_modproyect Esos métodos devuelven las
 * matrículas. Yo los metería en un arraylist y llamaría al mismo método que se
 * llama al añadir proyecto, que se llama meterAlumnosEnProyecto y que necesita
 * como parámetro un ArrayList de String
 * 
 */

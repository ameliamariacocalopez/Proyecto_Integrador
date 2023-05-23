package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.AccesoBBDD;
import vista.ConsulProyect;
import vista.VentanaPrincipal;

/**
 * @author Paula M.
 *
 */

public class ControladorProyecto implements ActionListener {
	
	private VentanaPrincipal vista;
	private AccesoBBDD modelo;
	
	public ControladorProyecto(VentanaPrincipal v) {
		vista = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		DatosProyecto datosProy = new DatosProyecto();
//		datosProy.setUsername(v.getUserTxtF().getText());
//		datosProy.setPassword(String.copyValueOf(v.getPasswTxtF().getPassword()));
//		System.out.println(datosProy.getUsername());
//		System.out.println(datosProy.getPassword());
//		datosProy.getConection();
	}

}
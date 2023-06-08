package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import vista.AyudaProyect;
import vista.VentanaPrincipal;

/**
 * Clase que implementa la interfaz ActionListener para el botÃ³n de Ayuda.
 * Abre la ventana de AyudaProyect al hacer clic en el botÃ³n.
 */
public class AyudaBtnListener implements ActionListener {

	/**
     * MÃ©todo que se ejecuta al hacer clic en el botÃ³n de Ayuda.
     * Abre la ventana de AyudaProyect.
     * @param e El evento de acciÃ³n generado por el botÃ³n de Ayuda.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
        AyudaProyect ayudaProy = new AyudaProyect();
        ayudaProy.hacerVisible();
   }
	
}
